import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class DormAndMealPlanCalculator extends JFrame {
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new DormAndMealPlanCalculator();
	}

	private JLabel Lab; 
	private JPanel DormPanel; 
	private JPanel DormPanelselected;
	private JComboBox DormBox;
	private JTextField Dormselected;
	private JPanel PanelforMeal;
	private JPanel MealPanelselected;
	private JComboBox MealBox;
	private JTextField Mealselected; 
	private JPanel panelfortotal;

	private JTextField tot;
	private String[] dormitory = { "Allen Hall $" + 1800, "Pike Hall $" + 2200, "Farthing Hall $" + 2800,
			"University Suites $" + 3000 };
	double[] dormRate = { 1800, 2200, 2800, 3000 };
	private String[] Meals = { "7 Meals Per Week $" + 600, "14 Meals Per Week $" + 1100, "Unlimited Meals $" + 1800 };
	double[] mealRate = { 600, 1100, 1500 };
	public DormAndMealPlanCalculator() {
		setTitle("Dorm and Meal Plan Calculator."); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLayout(new GridLayout(3, 2)); 
		builddormitory();
		buildmeals();
		buildtotal();
		add(DormPanel);
		add(PanelforMeal);
		add(panelfortotal);
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		int dorm;
		int meal;
		double total1;
		DormBox.getSelectedItem();
		dorm = DormBox.getSelectedIndex();
		MealBox.getSelectedItem();
		meal = MealBox.getSelectedIndex();
		total1 = dormRate[dorm] + mRate[meal];
		tot.setText("$" + total1);
	}
	private void builddormitory() {
		DormPanel = new JPanel();
		DormBox = new JComboBox(dormitory);
		DormBox.addActionListener(DormBox);
		DormPanel.add(DormBox);
	}
	private void buildmeals() {
		PanelforMeal = new JPanel();
		MealBox = new JComboBox(Meals);
		MealBox.addActionListener(MealBox);
		PanelforMeal.add(MealBox);
	}
	public void builddormselected() {
		DormPanelselected = new JPanel(); 
		Lab = new JLabel("Your Dormitory Is: "); 
		Dormselected = new JTextField(20);
		Dormselected.setEditable(false);
		DormPanelselected.add(Lab);
		DormPanelselected.add(Dormselected);
	}
	public void buildmealselected() {
		MealPanelselected = new JPanel(); 
		Lab = new JLabel("Your Meal Plan Is: ");
		Mealselected = new JTextField(20);
		Mealselected.setEditable(false);
		MealPanelselected.add(Lab);
		MealPanelselected.add(Mealselected);
	}
	private void buildtotal() {
		panelfortotal = new JPanel(); 
		Lab = new JLabel("Your Total Charges For the Semester Is: $"); 
		tot = new JTextField(15);
		tot.setEditable(false);
		panelfortotal.add(Lab);
		panelfortotal.add(tot);
	}

}
