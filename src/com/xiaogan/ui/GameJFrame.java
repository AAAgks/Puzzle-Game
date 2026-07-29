package com.xiaogan.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameJFrame extends JFrame implements ActionListener,KeyListener{
    int[][] data=new int[4][4];
    int stepCount=0;
    int x=0;
    int y=0;
    String file_path="image/animal/animal1/";
    private static final String[][] IMAGE_SETS = {
            {"动物", "animal", "8"},
            {"美女", "girl",   "11"},
            {"运动", "sport",  "10"},
    };

    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");


    private Map<JMenuItem, String> imagePathMap;

    public void setPath(String filepath){
        this.file_path=filepath;
    }



    public GameJFrame() {

        

        imagePathMap = new HashMap<>();

        initJFrame();

        initMenuBar();

        initDate();

        initImage();



        this.setVisible(true);
    }


    private void initDate() {
        Random r = new Random();
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        for (int i = tempArr.length-1; i >= 0; i--) {
            int index=r.nextInt(i+1);
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            int row = i / 4;
            int col = i % 4;
            data[row][col] = tempArr[i];
            // 只记录空白坐标
            if (tempArr[i] == 0) {
                x = row;
                y = col;
            }
        }

    }

    private void initImage() {

        getContentPane().removeAll();

        if(win()){
            JLabel winImage=new JLabel(new ImageIcon("image/win.png"));
            winImage.setBounds(203,283,197,73);
            getContentPane().add(winImage);
            System.out.println("win");
        }

        JLabel step = new JLabel("步数：" + stepCount);
        step.setBounds(50, 30, 100, 20);
        getContentPane().add(step);



        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel=new JLabel(new ImageIcon(file_path+num+".jpg"));
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                getContentPane().add(jLabel);
            }
        }

        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(40, 40, 508, 560);
        getContentPane().add(background);


        getContentPane().repaint();

    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");
        JMenu changeImage =new JMenu("更换图片");


        for (String[] set : IMAGE_SETS) {
            String label  = set[0];
            String folder = set[1];
            int count     = Integer.parseInt(set[2]);
            JMenu subMenu = new JMenu(label);
            for (int i = 1; i <= count; i++) {
                String path = "image/" + folder + "/" + folder + i + "/";
                JMenuItem item = new JMenuItem(label + i);
                imagePathMap.put(item, path);
                item.addActionListener(this);
                subMenu.add(item);
            }
            changeImage.add(subMenu);
        }

        replayItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        functionMenu.add(changeImage);
        functionMenu.add(replayItem);
        functionMenu.add(closeItem);

        aboutMenu.add(accountItem);

        menuBar.add(functionMenu);
        menuBar.add(aboutMenu);

        this.setJMenuBar(menuBar);
    }

    public void initJFrame(){
        this.setSize(603, 680);
        this.setAlwaysOnTop(true);
        this.setTitle("拼图游戏");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        addKeyListener(this);
    }

    public void oneKetFinish(){
        getContentPane().removeAll();

        int[] tempArr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j]=tempArr[i*4+j];
                JLabel jLabel=new JLabel(new ImageIcon(file_path+tempArr[i*4+j]+".jpg"));
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                getContentPane().add(jLabel);
            }
        }

        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(40, 40, 508, 560);
        getContentPane().add(background);

        x=3;
        y=3;

        getContentPane().repaint();
    }

    public boolean win(){
        int[][] win={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,0}
        };

        for (int i = 0; i < win.length; i++) {
            for (int j = 0; j < win[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void replay(){
        stepCount=0;
        initDate();
        initImage();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_SPACE){
            getContentPane().removeAll();
            JLabel allImage=new JLabel(new ImageIcon(file_path+"all.jpg"));
            allImage.setBounds(83,134,420,420);
            allImage.setBorder(new BevelBorder(BevelBorder.RAISED));
            getContentPane().add(allImage);

            JLabel background = new JLabel(new ImageIcon("image/background.png"));
            background.setBounds(40, 40, 508, 560);
            getContentPane().add(background);


            getContentPane().repaint();




        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(win()){
            return;
        }
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_LEFT){
            if(y==3) return;
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            stepCount++;
            initImage();


        }
        if(code==KeyEvent.VK_UP){
            if(x==3) return;
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            stepCount++;
            initImage();

        }

        if(code==KeyEvent.VK_RIGHT){
            if(y==0) return;
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            stepCount++;
            initImage();
        }
        if(code==KeyEvent.VK_DOWN){
            if(x==0) return;
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            stepCount++;
            initImage();
        }

        if(code==KeyEvent.VK_SPACE){
            initImage();
        }

        if(code==KeyEvent.VK_ENTER){
            oneKetFinish();
            initImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JMenuItem item && imagePathMap.containsKey(item)) {
            setPath(imagePathMap.get(item));
            initDate();
            initImage();
            return;
        }

        if(source == replayItem){
            replay();
        }

        if(source == closeItem){
            System.exit(0);
        }

        if(source == accountItem){
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("image/aboutMe.jpg"));
            jLabel.setBounds(0, 0, 640, 640);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(640, 640);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
    }
}
