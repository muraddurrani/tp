package seedu.address.model.meeting;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;


/**
 * Stores the details to edit the meeting with. Each non-empty field value will replace the
 * corresponding field value of the person.
 */
public class EditMeetingDescriptor {
    private Agenda agenda;
    private MeetingPlace meetingPlace;
    private MeetingTime meetingTime;
    private HashSet<Index> attendees;

    public EditMeetingDescriptor() {
    }

    /**
     * Copy constructor.
     * A defensive copy of {@code attendees} is used internally.
     */
    public EditMeetingDescriptor(EditMeetingDescriptor toCopy) {
        setAttendees(toCopy.attendees);
        setMeetingTime(toCopy.meetingTime);
        setMeetingPlace(toCopy.meetingPlace);
        setAgenda(toCopy.agenda);
    }

    /**
     * Meeting constructor.
     */
    public EditMeetingDescriptor(Meeting toCopy) {
        setAgenda(toCopy.getAgenda());
        setMeetingPlace(toCopy.getPlace());
        setMeetingTime(toCopy.getTime());
        setAttendees(toCopy.getIndexes());
    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(agenda, attendees, meetingPlace, meetingTime);
    }

    //----Single data fields----
    //Agenda
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Optional<Agenda> getAgenda() {
        return Optional.ofNullable(agenda);
    }

    //MeetingPlace
    public void setMeetingPlace(MeetingPlace meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public Optional<MeetingPlace> getMeetingPlace() {
        return Optional.ofNullable(meetingPlace);
    }

    //MeetingTime
    public void setMeetingTime(MeetingTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public Optional<MeetingTime> getMeetingTime() {
        return Optional.ofNullable(meetingTime);
    }

    /**
     * Sets {@code attendees} to this object's {@code attendees}.
     * A defensive copy of {@code attendees} is used internally.
     */
    public void setAttendees(Set<Index> attendees) {
        this.attendees = (attendees != null) ? new HashSet<>(attendees) : null;
    }

    /**
     * Returns an unmodifiable index set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     * Returns {@code Optional#empty()} if {@code attendees} is null.
     */
    public Optional<Set<Index>> getAttendees() {
        return (attendees != null) ? Optional.of(Collections.unmodifiableSet(attendees)) : Optional.empty();
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditMeetingDescriptor)) {
            return false;
        }

        // state check
        EditMeetingDescriptor e = (EditMeetingDescriptor) other;

        return getAgenda().equals(e.getAgenda())
                && getMeetingPlace().equals(e.getMeetingPlace())
                && getMeetingTime().equals(e.getMeetingTime())
                && getAttendees().equals(e.getAttendees());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("EditMeetingDescriptor: [");
        Set<Index> attendees = getAttendees().get();
        builder.append("Attendees: ");
        attendees.forEach(index -> builder.append(index).append(" "));

        builder.append("; Agenda: ")
                .append(getAgenda())
                .append("; MeetingPlace: ")
                .append(getMeetingPlace())
                .append("; MeetingTime: ")
                .append(getMeetingTime());

        builder.append("]");
        return builder.toString();
    }
}