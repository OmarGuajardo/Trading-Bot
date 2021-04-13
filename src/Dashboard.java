import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Dashboard extends JFrame
{
    private String[] columnNames = {"Index","Ticker","Current Price","Price of Purchase","Earnings","Shares","Suggested Move"} ;
    private Object[][] data={{"","","","","","",""}};
    private JTable table;
    private DefaultTableModel dm;
    private JScrollPane scroll;


    private JTextField TickerNumber1,ShareNumber1,IndexNumber1,ShareNumber2,TickerNumber2,DepositAmount;

    private JButton BUY_button;
    private JButton SELL_button;
    private JButton ADD_button;
    private JButton DEPOSIT_button;
    private JButton PORTFOLIO_button;
    private JButton WATCHLIST_button;
    private JButton LOGOUT_button;

    public Dashboard()
    {
        super("Portfolio");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null);


        table = new JTable();
        dm = new DefaultTableModel(data, columnNames);
        table.setModel(dm);
        scroll = new JScrollPane(table);
        scroll.setSize(800, 270);
        scroll.setLocation(50, 50);
        add(scroll);

        
        
        //Earnings *add how to calculate earnings or function that does so
        JLabel messageLabel1 = new JLabel("Earnings: ");
        messageLabel1.setSize(100, 30);
        messageLabel1.setLocation(50, 520);
        add(messageLabel1);
        //Earnings

        //Dealing with Buying
        BUY_button = new JButton("BUY");
        BUY_button.setSize(100, 30);
        BUY_button.setLocation(290, 350);
        BUY_button.addActionListener(new BUY_buttonClicked());
        add(BUY_button);
        setVisible(true);

        TickerNumber1 = new JTextField(10);
        TickerNumber1.setHorizontalAlignment(JTextField.CENTER);
        TickerNumber1.setText("Ticker #");
        TickerNumber1.setSize(100, 30);
        TickerNumber1.setLocation(50, 350);
        add(TickerNumber1);

        ShareNumber1 = new JTextField(10);
        ShareNumber1.setHorizontalAlignment(JTextField.CENTER);
        ShareNumber1.setText("# of Shares");
        ShareNumber1.setSize(100, 30);
        ShareNumber1.setLocation(170, 350);
        add(ShareNumber1);
        //^^^Dealing with Buying^^^


        //Dealing With Selling
        SELL_button = new JButton("SELL");
        SELL_button.setSize(100, 30);
        SELL_button.setLocation(290, 400);
        SELL_button.addActionListener(new SELL_buttonClicked());
        add(SELL_button);
        setVisible(true);

        IndexNumber1 = new JTextField(10);
        IndexNumber1.setHorizontalAlignment(JTextField.CENTER);
        IndexNumber1.setText("Index #");
        IndexNumber1.setSize(100, 30);
        IndexNumber1.setLocation(50, 400);
        add(IndexNumber1);

        ShareNumber2 = new JTextField(10);
        ShareNumber2.setHorizontalAlignment(JTextField.CENTER);
        ShareNumber2.setText("# of Shares");
        ShareNumber2.setSize(100, 30);
        ShareNumber2.setLocation(170, 400);
        add(ShareNumber2);
        //^^Dealing with Selling^^


        //Add to watchlist
        ADD_button = new JButton("ADD TO WATCHLIST");
        ADD_button.setSize(200, 30);
        ADD_button.setLocation(170, 450);
        ADD_button.addActionListener(new ADD_buttonClicked());
        add(ADD_button);
        setVisible(true);

        TickerNumber2 = new JTextField(10);
        TickerNumber2.setHorizontalAlignment(JTextField.CENTER);
        TickerNumber2.setText("Ticker #");
        TickerNumber2.setSize(100, 30);
        TickerNumber2.setLocation(50, 450);
        add(TickerNumber2);
        //^^^Add to watchlist^^^


        // Deposit
        DEPOSIT_button = new JButton("DEPOSIT");
        DEPOSIT_button.setSize(100, 30);
        DEPOSIT_button.setLocation(750, 350);
        DEPOSIT_button.addActionListener(new DEPOSIT_buttonClicked());
        add(DEPOSIT_button);
        setVisible(true);


        DepositAmount = new JTextField(10);
        DepositAmount.setHorizontalAlignment(JTextField.CENTER);
        DepositAmount.setText("Amount of Money");
        DepositAmount.setSize(100, 30);
        DepositAmount.setLocation(630, 350);
        add(DepositAmount);
        // ^^^ Deposit ^^^


        // Portfolio
        PORTFOLIO_button = new JButton("PORTFOLIO");
        PORTFOLIO_button.setSize(130, 30);
        PORTFOLIO_button.setLocation(450, 520);
        PORTFOLIO_button.addActionListener(new PORTFOLIO_buttonClicked());
        add(PORTFOLIO_button);
        setVisible(true);
        // ^^^ Portfolio ^^^

        // Watchlist
        WATCHLIST_button = new JButton("WATCHLIST");
        WATCHLIST_button.setSize(130, 30);
        WATCHLIST_button.setLocation(600, 520);
        WATCHLIST_button.addActionListener(new WATCHLIST_buttonClicked());
        add(WATCHLIST_button);
        setVisible(true);
        // ^^^ Watchlist ^^^

        // Logout
        LOGOUT_button = new JButton("LOGOUT");
        LOGOUT_button.setSize(100, 30);
        LOGOUT_button.setLocation(750, 520);
        LOGOUT_button.addActionListener(new LOGOUT_buttonClicked());
        add(LOGOUT_button);
        setVisible(true);
        // ^^^ Logout ^^^



        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);


        
    }

    private class BUY_buttonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("BUY BUTTON WORKS");
        }
    }

    private class SELL_buttonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("SELL BUTTON WORKS");
        }
    }

    private class ADD_buttonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("ADD BUTTON WORKS");
        }
    }

    private class DEPOSIT_buttonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("DEPOSIT BUTTON WORKS");
        }
    }

    private class PORTFOLIO_buttonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("PORTFOLIO BUTTON WORKS");
        }
    }

    private class WATCHLIST_buttonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("BUY BUTTON WORKS");
        }
    }

    private class LOGOUT_buttonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("LOGOUT BUTTON WORKS");
            JOptionPane.showMessageDialog(null, "You've been logged out!");
            setVisible(false);
        }
    }

}


