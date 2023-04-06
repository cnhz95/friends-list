import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class ApplicationFrame extends JFrame {
    ApplicationFrame() {
        super("ChatApp");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        ArrayList<String> temp = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            temp.add("Person " + i);
        }
        FriendsList friendsList = new FriendsList(temp);

        ListSelectionListener listSelectionListener = event -> {
            JList source = (JList) event.getSource();
            if (!event.getValueIsAdjusting() && source.getSelectedValue() != null) {
                System.out.println(source.getSelectedValue().toString());
            }
        };
        friendsList.addListSelectionListener(listSelectionListener);
        //friendsList.setListState(false);

        friendsList.addFriend("Person10");

        this.add(friendsList, BorderLayout.EAST);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}