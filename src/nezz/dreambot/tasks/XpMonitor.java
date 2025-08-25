package nezz.dreambot.tasks;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.skills.Skill;

/**
 * Utility class that wraps DreamBot's {@link MethodProvider#getSkillTracker()} to
 * provide convenient helper methods for monitoring experience gains and levels.
 */
public class XpMonitor {

    private final MethodProvider provider;

    public XpMonitor(MethodProvider provider) {
        this.provider = provider;
    }

    /**
     * Starts tracking experience for the given skill.
     *
     * @param skill the skill to start tracking
     */
    public void start(Skill skill) {
        provider.getSkillTracker().start(skill);
    }

    /**
     * Returns {@code true} if the player has reached the desired level in the
     * specified skill.
     */
    public boolean reachedLevel(Skill skill, int level) {
        return provider.getSkills().getRealLevel(skill) >= level;
    }

    /**
     * Returns {@code true} if the player has gained at least the provided amount
     * of experience in the specified skill since {@link #start(Skill)} was called.
     */
    public boolean reachedExperience(Skill skill, int experience) {
        return provider.getSkillTracker().getGainedExperience(skill) >= experience;
    }

    /**
     * Convenience method for retrieving the gained experience per hour for the
     * supplied skill.
     */
    public int getXpPerHour(Skill skill) {
        return provider.getSkillTracker().getGainedExperiencePerHour(skill);
    }
}

