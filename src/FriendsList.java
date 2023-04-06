import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class FriendsList extends JPanel {
    private final JList<String> list;
    private final DefaultListModel<String> listModel;

    FriendsList(ArrayList<String> friends) {
        super(new BorderLayout());
        listModel = new DefaultListModel<>();
        for (int i = 1; i < friends.size(); i++) {
            addFriend(friends.get(i));
        }
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(8);
        this.setBorder(new EmptyBorder(10,10,10,10));
        this.add(new JScrollPane(list), BorderLayout.CENTER);
        this.add(new JLabel("Friends list"), BorderLayout.NORTH);
    }

    /**
     * Adds a ListSelectionListener to the list
     * @param listener ListSelectionListener to process list selection events
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        list.addListSelectionListener(listener);
    }

    /**
     * Adds a friend to the friends list
     * @param friendName String representing the name of the friend to add
     */
    public void addFriend(String friendName) {
        listModel.addElement(friendName);
    }

    /**
     * Enables or disables the list
     * @param state Boolean indicating the state to put the list in
     */
    public void setListState(boolean state) {
        list.setEnabled(state);
        //list.clearSelection();
    }
}