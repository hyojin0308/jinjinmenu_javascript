import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class 임효진_기말_project {
    int count = 0;
    String show = "";

    public 임효진_기말_project() {
        JFrame frame = new JFrame("진진차이나 주문");
        frame.setBounds(0, 0, 625, 1000);
        frame.setBackground(Color.black);
        frame.setSize(620, 800);

        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(224, 224, 224));
        pNorth.setLayout(null);
        pNorth.setSize(0, 500);

        String menu[] = { "얼큰짜장면", "진진짬뽕", "차돌짬뽕", "가리비짬뽕", "탕수육", "바매탕수육", "양장피", "크림새우", };
        int price[] = { 7000, 8000, 10000, 13000, 18000, 18000, 18000, 17000, 8000 };
        JButton bt[] = new JButton[menu.length];
        TextField suja[] = new TextField[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length];
        JButton ok[] = new JButton[menu.length];
        Label l[] = new Label[menu.length];
        ImageIcon icon[] = new ImageIcon[menu.length];

        JLabel nameLabel = new JLabel();

        nameLabel.setIcon(new ImageIcon("C:\\Users\\dlagy\\Desktop\\images/진진차이나.jpg"));
        nameLabel.setBounds(220, 4, 155, 40);

        pNorth.add(nameLabel);

        for (int i = 0; i < menu.length; i++) {
            Rectangle rect = new Rectangle();

            if (i < 4) {
                rect = new Rectangle(25 + i * 150, 50, 100, 100);
            } else {
                rect = new Rectangle(25 + (i - 4) * 150, 300, 100, 100);
            }

            icon[i] = new ImageIcon(new ImageIcon("C:\\Users\\dlagy\\Desktop\\images/" + menu[i] + ".jpg").getImage().getScaledInstance(
                    (int) rect.getWidth(),
                    (int) rect.getHeight(),
                    Image.SCALE_AREA_AVERAGING));

            bt[i] = new JButton(menu[i], icon[i]);
            bt[i].setForeground(Color.white);
            bt[i].setHorizontalTextPosition(JButton.CENTER); // 텍스트 가운데
            bt[i].setBounds(rect);

            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);

            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
            minus[i].setEnabled(false);

            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);

            l[i] = new Label(price[i] + "원");
            l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 25, 100, 20);

            ok[i] = new JButton("확인");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);

            pNorth.add(bt[i]);
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(l[i]);
            pNorth.add(ok[i]);
        }

        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   상품명        단가        수량        합계\n\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);

        Panel pSouth = new Panel();

        pSouth.setBackground(new Color(224, 224, 224));

        Button bt1 = new Button("주문");
        Button bt2 = new Button("초기화");
        Button bt3 = new Button("닫기");
        pSouth.add(bt1);
        pSouth.add(bt2);
        pSouth.add(bt3);

        bt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다. \n이용해주셔서 감사합니다.");
                for (int i = 0; i < menu.length; i++) {
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    ta.setText("   상품명        단가        수량        합계\n\n");

                }
            }
        });

        bt2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < menu.length; i++) {
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    ta.setText("   상품명        단가        수량        합계\n\n");

                }
            }
        });

        bt3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(ta, BorderLayout.CENTER);
        frame.add(pSouth, BorderLayout.SOUTH);
        frame.setVisible(true);

        for (int i = 0; i < menu.length; i++) {
            int j = i;

            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minus[j].setEnabled(true);
                    plus[j].setEnabled(true);
                    bt[j].setEnabled(false);
                    ok[j].setEnabled(true);

                    count = 0;
                }
            });

            minus[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        suja[j].setText(count + "");
                        ok[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });

            plus[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    suja[j].setText(count + "");
                    ok[j].setEnabled(true);
                    if (count > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });

            ok[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    show = bt[j].getActionCommand();
                    ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
                            + "원" + "\n");
                    ok[j].setEnabled(false);
                }
            });

        }

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new 임효진_기말_project();
        
    }

}
