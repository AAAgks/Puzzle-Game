package com.xiaogan.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    JButton jtb1=new JButton("jtb1");
    JButton jtb2=new JButton("jtb2");

    public MyJFrame(){
        setSize(603, 680);
        setTitle("事件演示");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        jtb1.setBounds(0,0,100,50);
        jtb1.addActionListener(this);
        this.getContentPane().add(jtb1);


        jtb2.setBounds(100,100,100,50);
        jtb2.addActionListener(this);
        this.getContentPane().add(jtb2);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Random r=new Random();
        int index=r.nextInt(500);
        Object source = e.getSource();
        if(source==jtb1)
            jtb1.setBounds(500,500,100,50);
        else if(source==jtb2)
            jtb2.setLocation(index,index);
    }


}

