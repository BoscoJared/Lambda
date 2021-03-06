package com.jvmrally.lambda.modmail;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.MessageEmbed.Field;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

/**
 * ModmailResponseHandler
 */
public class ModmailCommunicationHandler {
        private static final Logger LOGGER = LogManager.getLogger(ModmailCommunicationHandler.class);

        public void handleModResponse(MessageReceivedEvent event) {

                var modMessage = event.getMessage();
                if (isInModMailChannel(event) && !event.getAuthor().isBot() && messageIsNotCommand(modMessage)) {
                        var participiant = getModMailParticipiant(event.getJDA(),
                                        getParticipiantId(event.getTextChannel()));
                        LOGGER.info("[{}|{}] answered to case [{}|{}]", event.getAuthor().getAsTag(),
                                        event.getAuthor().getAvatarId(), participiant.getAsTag(), participiant.getId());
                        participiant.openPrivateChannel().queue(channel -> channel.sendMessage(modMessage).queue(null,
                                        (ignore) -> modMessage.addReaction("❌").queue()));
                }
        }

        public void handleDirectMessage(PrivateMessageReceivedEvent event) {
                LOGGER.info("Received modmail message by user: [{}|{}]", event.getAuthor().getAsTag(),
                                event.getAuthor().getId());
                var caseChannel = new ModmailChannelManagement(event.getJDA()).getCaseChannel(event.getAuthor());
                caseChannel.sendMessage(event.getMessage()).queue();
        }

        private boolean isInModMailChannel(MessageReceivedEvent event) {
                var categories = event.getGuild().getCategoriesByName("reports", true);
                return categories.stream().map(category -> category.getChannels())
                                .flatMap(channels -> channels.stream())
                                .anyMatch(channel -> channel.getIdLong() == event.getChannel().getIdLong());
        }

        private boolean messageIsNotCommand(Message message) {
                return !message.getContentRaw().trim().startsWith("!modmail");
        }

        public static User getModMailParticipiant(JDA jda, long participiantId) {
                return jda.getGuilds().stream().map(guild -> guild.getMemberById(participiantId))
                                .reduce((result, ignore) -> result).orElseThrow(() -> new IllegalStateException(
                                                "Could not find user with ID: " + participiantId))
                                .getUser();
        }

        public static long getParticipiantId(TextChannel modmailChannel) {
                var firstMessage = Objects.requireNonNull(
                                modmailChannel.getHistoryFromBeginning(1).complete().getRetrievedHistory().get(0),
                                "Could not receive first message in channel: " + modmailChannel.getName());

                var infoEmbed = firstMessage.getEmbeds().stream().reduce((result, ignore) -> result).orElseThrow(
                                () -> new IllegalStateException("Could not receive info embed from first message"));

                return infoEmbed.getFields().stream().filter(field -> field.getName().equals("ID")).map(Field::getValue)
                                .map(Long::parseLong).reduce((result, ignore) -> result)
                                .orElseThrow(() -> new IllegalStateException(
                                                "Could not find embed with field 'ID' in the first message of channel: "
                                                                + modmailChannel.getName()));
        }
}