package com.xiaogan.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
    JButton jtb=new JButton("jtb1");

    public MyJFrame2(){
        setSize(603, 680);
        setTitle("事件演示");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        jtb.setBounds(0,0,100,50);
        jtb.addMouseListener(this);


        this.getContentPane().add(jtb);


        setVisible(true);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("释放");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("进入");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("退出");

    }
}
