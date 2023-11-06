import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Java GUI 单机版五子棋
 * https://www.cnblogs.com/huanzi-qch/p/10008261.html
 */
@SuppressWarnings("ALL")
public class Gobang extends Frame {
    private static int y;// 鼠标点击的X轴
    private static int x;// 鼠标点击的Y轴
    private int[][] xY = new int[400][2];// 定义二维数组x_y来保存每一个棋子的坐标，用于界面的展示
    private int a = 0;//定义一个变量表示已经保存了的坐标数
    private static String[][] str = new String[20][20];// 定义一个二维数组str来保存每一个棋子的位置和颜色，用于判断输赢
    private boolean isWhite = true;// 棋子的颜色是否为白色
    static boolean flagWin = false;// 是否分出输赢
    private boolean isClick = false;// 是否点击了鼠标
    private int win;// 判断是白棋赢还是黑棋赢，返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
    private String whoWin = "";//谁赢了

    /**
     * 初始化str,二维数组str来保存每一个棋子的位置和颜色，用于判断输赢
     */
    private static void initStr() {

        // 初始化str
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length; j++) {
                str[i][j] = "*";
            }
        }
    }

    /**
     * 判断输赢，返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
     */
    private static int win(String s) {
        final int b = 1;
        final int h = 2;
        int win = 0;

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length; j++) {
                // 横向的判断
                if (j < str[0].length - 4) {
                    if (s.equals(str[i][j]) && s.equals(str[i][j + 1])
                            && s.equals(str[i][j + 2])
                            && s.equals(str[i][j + 3])
                            && s.equals(str[i][j + 4])) {
                        // 返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
                        if ("O".equals(s)) {
                            win = b;
                        }
                        if ("@".equals(s)) {
                            win = h;
                        }
                        return win;
                    }
                }
                // 横向的判断
                if (j > 4) {
                    if (s.equals(str[i][j - 4])
                            && s.equals(str[i][j - 3])
                            && s.equals(str[i][j - 2])
                            && s.equals(str[i][j - 1])
                            && s.equals(str[i][j])) {
                        // 返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
                        if ("O".equals(s)) {
                            win = b;
                        }
                        if ("@".equals(s)) {
                            win = h;
                        }
                        return win;
                    }
                }
                // 纵向的判断
                if (i < str.length - 4) {
                    if (s.equals(str[i][j])
                            && s.equals(str[i + 1][j])
                            && s.equals(str[i + 2][j])
                            && s.equals(str[i + 3][j])
                            && s.equals(str[i + 4][j])) {
                        // 返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
                        if ("O".equals(s)) {
                            win = b;
                        }
                        if ("@".equals(s)) {
                            win = h;
                        }
                        return win;
                    }
                }
                // 纵向的判断
                if (i > 4) {
                    if (s.equals(str[i - 4][j])
                            && s.equals(str[i - 3][j])
                            && s.equals(str[i - 2][j])
                            && s.equals(str[i - 1][j])
                            && s.equals(str[i][j])) {
                        // 返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
                        if ("O".equals(s)) {
                            win = b;
                        }
                        if ("@".equals(s)) {
                            win = h;
                        }
                        return win;
                    }
                }
                // 捺方向的判断
                if (i < str.length - 4 && j < str[0].length - 4) {
                    if (s.equals(str[i][j])
                            && s.equals(str[i + 1][j + 1])
                            && s.equals(str[i + 2][j + 2])
                            && s.equals(str[i + 3][j + 3])
                            && s.equals(str[i + 4][j + 4])) {
                        // 返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
                        if ("O".equals(s)) {
                            win = b;
                        }
                        if ("@".equals(s)) {
                            win = h;
                        }
                        return win;
                    }
                }
                // 捺方向的判断
                if (i > 4 && j > 4) {
                    if (s.equals(str[i - 4][j - 4])
                            && s.equals(str[i - 3][j - 3])
                            && s.equals(str[i - 2][j - 2])
                            && s.equals(str[i - 1][j - 1])
                            && s.equals(str[i][j])) {
                        // 返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
                        if ("O".equals(s)) {
                            win = b;
                        }
                        if ("@".equals(s)) {
                            win = h;
                        }
                        return win;
                    }
                }
                // 撇丿方向的判断
                if (j >= 4 && i < str.length - 4) {
                    if (s.equals(str[i][j])
                            && s.equals(str[i + 1][j - 1])
                            && s.equals(str[i + 2][j - 2])
                            && s.equals(str[i + 3][j - 3])
                            && s.equals(str[i + 4][j - 4])) {
                        // 返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
                        if ("O".equals(s)) {
                            win = b;
                        }
                        if ("@".equals(s)) {
                            win = h;
                        }
                        return win;
                    }
                }
                // 撇丿方向的判断
                if (i >= 4 && j < str[0].length - 4) {
                    if (s.equals(str[i - 4][j + 4])
                            && s.equals(str[i - 3][j + 3])
                            && s.equals(str[i - 2][j + 2])
                            && s.equals(str[i - 1][j + 1])
                            && s.equals(str[i][j])) {
                        // 返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
                        if ("O".equals(s)) {
                            win = b;
                        }
                        if ("@".equals(s)) {
                            win = h;
                        }
                        return win;
                    }
                }
            }
        }
        // 返回0，还没有人赢，返回1，白棋赢，返回2，黑棋赢
        return win;
    }

    /**
     * 判断是否和棋 返回true则棋盘上已经放满了 返回false则表示还没有放满
     */
    private static boolean isDraw() {
        for (String[] aStr : str) {
            for (int j = 0; j < str[0].length; j++) {
                if ("*".equals(aStr[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 对落子位置的逻辑判断
     */
    private void ifPrint(Graphics g) {

        // 如果已经分出胜负
        if (!flagWin) {
            // 是否为和棋
            if (!isDraw()) {
                //判断画笔颜色
                if (isWhite) {
                    g.setColor(Color.WHITE);//定义画笔颜色
                    g.drawString("白棋走棋", 660, 100);
                } else {
                    g.setColor(Color.BLACK);//定义画笔颜色
                    g.drawString("黑棋走棋", 660, 100);
                }
                // 往空格添加棋子
                if (isClick) {// 是否点击了鼠标
                    if (x > 50 && x < 650 && y > 50 && y < 650) {// 是否在正确的位置下子
                        for (int i = 50; i < 650; i += 30) {
                            for (int j = 50; j < 650; j += 30) {
                                if (x > i && x < i + 30 && y > j && y < j + 30) {// 判断是在哪一个空格下子
                                    if ("*".equals(str[(j - 50) / 30][(i - 50) / 30])) {// 判断该空格是否已经有子

                                        if (isWhite) {// 判断下的棋子的颜色
                                            g.setColor(Color.WHITE);//定义画笔颜色
                                            str[(j - 50) / 30][(i - 50) / 30] = "O";// 保存棋子的位置和颜色
                                        } else {
                                            g.setColor(Color.BLACK);//定义画笔颜色
                                            str[(j - 50) / 30][(i - 50) / 30] = "@";
                                        }
                                        g.fillOval(i, j, 30, 30);// //画棋子，实心圆
                                        // 保存棋子的坐标
                                        xY[a][0] = i;
                                        xY[a][1] = j;

                                        System.out.println("x:" + x + "    y:" + y
                                                + "a:" + a + "  teyp" + isWhite);
                                        a++;
                                        // 重置坐标
                                        x = 0;
                                        y = 0;
                                        isWhite = !isWhite;

                                        for (int i1 = 0; i1 < str.length; i1++) {
                                            for (int j1 = 0; j1 < str[0].length; j1++) {
                                                System.out.print(str[i1][j1] + " ");
                                            }
                                            System.out.println("");
                                        }
                                    } else {
                                        g.setColor(Color.RED);//定义画笔颜色
                                        g.drawString("该位置已经有子，请从新下！", 660, 120);
                                        System.out.println("该位置已经有子，请从新下！");
                                    }
                                }
                            }
                        }
                    } else {
                        g.setColor(Color.RED);//定义画笔颜色
                        g.drawString("请在正确的位置放子！", 660, 120);
                        System.out.println("请在正确的位置放子！");
                    }
                    isClick = false;
                }

                if (!isWhite) {// 因为前面下完子之后已经取反了，所以这里取非
                    win = win("O");// 判断白棋是否赢
                } else {
                    win = win("@");// 判断黑棋是否赢
                }
                switch (win) {
                    case 1:
                        System.out.println("白棋赢了");
                        flagWin = true;
                        whoWin = "白棋赢了";
                        break;
                    case 2:
                        System.out.println("黑棋赢了");
                        flagWin = true;
                        whoWin = "黑棋赢了";
                        break;
                    default:

                }
            } else {
                g.setColor(Color.RED);//定义画笔颜色
                g.drawString("和棋!!!", 660, 100);
                g.drawString("你们打成了平手！", 660, 120);
            }
        } else {
            g.setColor(Color.RED);//定义画笔颜色
            g.drawString(whoWin, 660, 100);
            g.drawString("已经分出了胜负啦！", 660, 120);
        }

    }

    /**
     * 初始化窗口
     */
    private void launchFrame() {

        // 设置窗口大小
        setSize(800, 700);
        // 设置窗口位置
        setLocation(50, 50);
        // 设置背景颜色
        setBackground(Color.PINK);
        // 设置窗口可见
        setVisible(true);
        // 设置标题
        setTitle("欢子出品，必属精品");
        // 设置窗口大小不可变
        setResizable(false);
        // 启用线程
        new PaintThread().start();

        // 添加窗口监听，实现窗口关闭
        addWindowListener(new MyWindow());
        // 添加鼠标监听
        addMouseListener(new MyMouse());

    }

    /**
     * 画窗体里的内容
     */
    @Override
    public void paint(Graphics g) {
        //初始化画笔的颜色
        g.setColor(Color.BLACK);

        // 画线，画方格
        // X轴方向
        for (int i = 0, j = 50; i <= 20; i++) {
            g.drawLine(50, j, 650, j);
            j += 30;
        }

        // Y轴方向
        for (int i = 0, j = 50; i <= 20; i++) {
            g.drawLine(j, 50, j, 650);
            j += 30;
        }

        // 画棋子
        for (int i = 0; i < a; i++) {
            if ("O".equals(str[(xY[i][1] - 50) / 30][(xY[i][0] - 50) / 30])) {
                g.setColor(Color.WHITE);//定义画笔颜色
            } else if ("@"
                    .equals(str[(xY[i][1] - 50) / 30][(xY[i][0] - 50) / 30])) {
                g.setColor(Color.BLACK);//定义画笔颜色
            }
            g.fillOval(xY[i][0], xY[i][1], 30, 30);//画棋子，实心圆
        }

        //对落子位置的逻辑判断
        ifPrint(g);

        //恢复画笔的颜色
        g.setColor(Color.BLACK);

    }

    /**
     * 退出
     */
    class MyWindow extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    /**
     * 定义一个鼠标监听事件类
     */
    class MyMouse implements MouseListener {

        /**
         * 鼠标释放
         */
        @Override
        public void mouseReleased(MouseEvent arg0) {
            // System.out.println("鼠标释放"+arg0);

        }

        /**
         * 鼠标按下
         */
        @Override
        public void mousePressed(MouseEvent arg0) {
            // System.out.println("鼠标按下"+arg0);

        }

        /**
         * 鼠标离开
         */
        @Override
        public void mouseExited(MouseEvent arg0) {
            // System.out.println("鼠标离开）"+arg0);
        }

        /**
         * 鼠标进入
         */
        @Override
        public void mouseEntered(MouseEvent arg0) {
            // System.out.println("鼠标进入）"+arg0);
        }

        /**
         * 鼠标点击
         */
        @Override
        public void mouseClicked(MouseEvent arg0) {
            x = arg0.getX();
            y = arg0.getY();
            isClick = true;
        }
    }

    /**
     * 定义一个线程重画窗口，是一个内部类
     */
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * main函数
     */
    public static void main(String[] args) {
        new Gobang().launchFrame();
        initStr();
    }
}