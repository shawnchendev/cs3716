import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddTeamDialog extends JDialog {
	private JPanel contentPane;
	private JComboBox teamBox;

	public AddTeamDialog() {
		contentPane = new JPanel();
		setTitle("Add Team");
		setBounds(100, 100, 400, 300);
		setContentPane(contentPane);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPane.setLayout(new GridLayout(3, 1));
		JPanel boxPane = new JPanel();
		boxPane.setLayout(new GridLayout(1, 2));
		JLabel lbl = new JLabel("Team");
		teamBox = new JComboBox();
		
		boxPane.add(lbl);
		boxPane.add(teamBox);

		JPanel buttonPane = new JPanel();
		JButton addButton = new JButton("Add");
		JButton cancelButton = new JButton("Cancel");

		ActionListener buttonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(addButton)) {
					
				}
				if (e.getSource().equals(cancelButton)) {
					dispose();
				}

			}

		};

		buttonPane.add(addButton);
		buttonPane.add(cancelButton);
		contentPane.add(boxPane);
		contentPane.add(buttonPane);
		setResizable(false);
		setVisible(true);

	}
}
