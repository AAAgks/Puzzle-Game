package com.xiaogan.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 {
    public static void main(String[] args){
        JFrame jframe=new JFrame();
        jframe.setSize(603, 680);
        jframe.setTitle("事件演示");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.setLayout(null);

        JButton jtb1=new JButton("jtb1");
        jtb1.setBounds(0,0,100,50);
        jtb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("jtb1");
            }
        });
        jframe.getContentPane().add(jtb1);

        JButton jtb2=new JButton("jtb2");
        jtb2.setBounds(100,100,100,50);
        jtb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("jtb2");
            }
        });
        jframe.getContentPane().add(jtb2);

        jframe.setVisible(true);
    }
}
