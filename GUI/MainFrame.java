import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame {

	private JPanel content_panel;
	private JPanel ListPane;
	private JPanel ButtonPane;

	private JList TournamentList;
	private JButton create_b, refresh_b;
	private JButton register_b;
	private JButton registerCoach_b;
	private JButton viewTournament_b, viewTeam_b;

	private DefaultListModel<String> tournament;
	private ArrayList<Tournament> t;
	private int frameWidth = 500;
	private int frameHeight = 300;

	public MainFrame() {

		t = new ArrayList<Tournament>();

		tournament = new DefaultListModel<String>();

		setTitle("Volleyball Tournament");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, frameWidth, frameHeight);

		content_panel = new JPanel();
		content_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		content_panel.setLayout(new GridLayout(1, 2, 10, 10));

		setContentPane(content_panel);

		TournamentList = new JList(tournament); // data has type Object[]
		TournamentList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		TournamentList.setVisibleRowCount(-1);
		TournamentList.setFixedCellWidth((int) (0.45 * frameWidth));

		readTournaments();

		JScrollPane listScroller = new JScrollPane(TournamentList);
		listScroller.setPreferredSize(new Dimension(250, 80));

		ListPane = new JPanel();
		ListPane.setLayout(new BorderLayout());
		ListPane.setBorder(new LineBorder(Color.BLACK));
		ListPane.setBackground(Color.WHITE);

		ButtonPane = new JPanel();
		ButtonPane.setLayout(new GridLayout(10, 1));
		ButtonPane.setBounds(360, 350, (int) (frameWidth / 2), (int) (0.45 * frameWidth));

		create_b = new JButton("Create Tournament");
		register_b = new JButton("Register Team");
		registerCoach_b = new JButton("RegisterCoach");
		refresh_b = new JButton("Refresh");
		viewTournament_b = new JButton("Select Tournament");
		viewTeam_b = new JButton("View All Team");

		// actionlister for the button
		ActionListener ButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(register_b)) {
					new RegisterDialog();
				} else if (e.getSource().equals(create_b)) {
					new CreateTournamentDialog(tournament);
				}

				else if (e.getSource().equals(registerCoach_b)) {
					new CoachDialog();
				}

				else if (e.getSource().equals(refresh_b)) {
					tournament.clear();
					readTournaments();
				} else if (e.getSource().equals(viewTournament_b)) {
					new TournamentFrame(TournamentList.getSelectedValue().toString());
				}
			}
		};

		ListSelectionListener listListener = new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

		};
		register_b.addActionListener(ButtonListener);
		create_b.addActionListener(ButtonListener);
		registerCoach_b.addActionListener(ButtonListener);
		viewTournament_b.addActionListener(ButtonListener);
		refresh_b.addActionListener(ButtonListener);

		ListPane.add(TournamentList);
		ButtonPane.add(create_b);
		ButtonPane.add(registerCoach_b);
		ButtonPane.add(register_b);
		ButtonPane.add(viewTournament_b);
		ButtonPane.add(viewTeam_b);
		ButtonPane.add(refresh_b);

		content_panel.add(ListPane);
		content_panel.add(ButtonPane);

	}

	private void readTournaments() {
		ReadFile r = new ReadFile("Tournament.txt");
		ArrayList<String> tournament_records = new ArrayList<String>();
		tournament_records = r.getLines();
		for (int i = 0; i < tournament_records.size(); i++) {
			String record = tournament_records.get(i);

			String[] Field = record.split("-");
			Tournament t1 = new Tournament();
			t1.setName(Field[0]);
			t1.setLocation(Field[1]);
			t.add(t1);

			tournament.addElement(t.get(i).getName());
		}
	}

	public static void main(String[] args) {

		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}
}
