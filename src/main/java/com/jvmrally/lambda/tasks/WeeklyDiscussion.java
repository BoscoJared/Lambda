package com.jvmrally.lambda.tasks;

import java.awt.Color;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import com.jvmrally.lambda.annotation.Task;
import com.jvmrally.lambda.utility.messaging.Messenger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * WeeklyDiscussion
 */
@Task(unit = TimeUnit.SECONDS, frequency = 604_800, delayStart = true)
public class WeeklyDiscussion implements Runnable, DelayedTask {

    private static final Logger logger = LogManager.getLogger(WeeklyDiscussion.class);
    private static final String DISCUSSION_CHANNEL = "weekly_discussion";
    private static final String CATEGORY = "general";
    private static final DayOfWeek TARGET_DAY = DayOfWeek.MONDAY;
    private static final LocalTime TARGET_TIME = LocalTime.of(9, 0);

    private final JDA jda;

    public WeeklyDiscussion(JDA jda) {
        this.jda = jda;
    }

    @Override
    public void run() {
        getChannel(DISCUSSION_CHANNEL).ifPresent(this::deleteDiscussion);
        createNewDiscussion();
    }

    private void createNewDiscussion() {
        var guilds = jda.getGuilds();
        if (guilds.size() == 1) {
            var guild = guilds.get(0);
            var categories = guild.getCategoriesByName(CATEGORY, true);
            if (categories.size() == 1) {
                createChannel(categories.get(0));
            }
        }
    }

    private void createChannel(Category category) {
        var createdChannel = category.createTextChannel(DISCUSSION_CHANNEL)
                .setTopic(getChannelTopic()).setSlowmode(5).complete();
        sendInitialMessage(createdChannel);
        logger.info("Channel created.");
    }

    private void sendInitialMessage(TextChannel channel) {
        Messenger.send(channel,
                "Here you can talk about anything that you're going to do for the upcoming week,"
                        + " whether it's for work, a personal project, something for your studies,"
                        + " or something else. We of course appreciate some people may not be"
                        + " willing or able (nda's etc.) to go into too much detail regarding"
                        + " their work so don't worry about keeping things vague.");
    }

    private String getChannelTopic() {
        StringBuilder sb = new StringBuilder();
        sb.append(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        sb.append(" - Language agnostic open discussion on what you're working on this week!");
        return sb.toString();
    }

    private void deleteDiscussion(TextChannel channel) {
        getChannel("archive").ifPresent(archive -> {
            for (Message message : channel.getIterableHistory()) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("**" + message.getAuthor().getName() + "'s message**");
                eb.setDescription(message.getContentRaw());
                eb.setColor(Color.WHITE);
                Messenger.send(archive, eb.build());
            }
        });
        channel.delete().queue();
        logger.info("Channel deleted.");
    }

    private Optional<TextChannel> getChannel(String channelName) {
        var channels = jda.getTextChannelsByName(channelName, true);
        if (channels.size() == 1) {
            return Optional.of(channels.get(0));
        }
        return Optional.empty();
    }

    @Override
    public long getTaskDelay() {
        // if current day is TARGET_DAY and current time is before target time then use nextOrSame
        // else use next
        var now = OffsetDateTime.now();
        var nowTime = LocalTime.now();
        var delayTime = OffsetDateTime.now();
        if (now.getDayOfWeek() == TARGET_DAY
                && !Duration.between(nowTime, TARGET_TIME).isNegative()) {
            delayTime = delayTime.with(TemporalAdjusters.nextOrSame(TARGET_DAY));
        } else {
            delayTime = delayTime.with(TemporalAdjusters.next(TARGET_DAY));
        }
        delayTime = delayTime.with(TARGET_TIME);
        return delayTime.toEpochSecond() - (System.currentTimeMillis() / 1000);
    }
}
