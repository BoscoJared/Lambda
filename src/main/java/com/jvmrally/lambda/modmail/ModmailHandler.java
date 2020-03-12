package com.jvmrally.lambda.modmail;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jvmrally.lambda.modmail.exception.CouldNotCreateChannelException;
import com.jvmrally.lambda.modmail.exception.NoSuchCategoryException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.Invite.Channel;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;

/**
 * ModmailHandler
 */
public class ModmailHandler {

    private final JDA jda;

    public ModmailHandler(JDA jda) {
        this.jda = Objects.requireNonNull(jda);
    }

    public TextChannel openNewChannel(User user) {
        Category category = fetchModmailCategory();
        var channelName = computeCaseChannelName(user);
        try {
            return category.createTextChannel(channelName).complete(true);
        } catch (RateLimitedException e) {
            throw new CouldNotCreateChannelException("Could not create channel: " + channelName, e);
        }
    }

    public void manageDirectMessage(PrivateMessageReceivedEvent event) {
        var caseChannel = getCaseChannel(event.getAuthor());
        caseChannel.sendMessage(formatDirectMessage(event)).queue();
    }

    private String formatDirectMessage(PrivateMessageReceivedEvent event) {
        return String.format("User: %s sent message: %s", event.getAuthor().getAsMention(),
                event.getMessage().getContentDisplay());
    }

    private String computeCaseChannelName(User user) {
        return user.getAsTag().toLowerCase().replace("#", "");
    }

    private TextChannel getCaseChannel(User user) {
        var potentialChannel = fetchOpenCaseChannel(user);
        if (potentialChannel.isPresent()) {
            return potentialChannel.get();
        }
        return openNewChannel(user);
    }

    private Category fetchModmailCategory() {
        final String CATEGORY_NAME = "reports";
        Optional<Category> potentialCategory = jda.getCategoriesByName(CATEGORY_NAME, false).stream()
                .reduce((x, ignore) -> x);

        if (!potentialCategory.isPresent()) {
            throw new NoSuchCategoryException("Could not find a category named: " + CATEGORY_NAME);
        }
        return potentialCategory.get();
    }

    private Optional<TextChannel> fetchOpenCaseChannel(User user) {
        var tag = user.getAsTag();
        Category category = fetchModmailCategory();
        var textChannels = category.getTextChannels();
        Optional<TextChannel> potentialChannel = textChannels.stream()
                .filter(x -> x.getName().contains(computeCaseChannelName(user))).reduce((x, ignore) -> x);
        return potentialChannel;
    }

}