package com.xiaogan.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {

    public MyJFrame3() {
        setSize(603, 680);
        setTitle("事件演示");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        this.addKeyListener(this);




        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==65){
            System.out.println("按下了A键");
        }
        System.out.println("按下了");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("释放了");
    }
}
