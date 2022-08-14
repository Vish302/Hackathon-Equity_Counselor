//Code by: Viswanath Balaji
//Artwork done by: Vaishnavi Balaji
//Story written by: Abbie Vijay

//Problem: Lack of Social Equity in Society

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.Objects;

public class Game {
    boolean buttonPressed = false;
    boolean nextOne = false;
    boolean first = true;
    boolean hallwayFirst = true;
    boolean hallway2First = true;
    boolean hallway3First = true;
    boolean classroomFirst = true;
    boolean studentHelperFirst = true;
    boolean principalFirst = true;
    boolean libraryFirst = true;
    boolean cafeteriaFirst = true;
    boolean officeFirst = true;
    boolean haveLunch = false;
    boolean helpingHolly = false;
    boolean doneHolly = false;
    boolean gaveLunch = false;
    int timeHandlerNum = 0, nextHandler = 0, story = 0, place = 0;
    int up = 0, down = 0, left = 0, right = 0;

    JFrame mainClassroom;
    JPanel titlePage, aTextbox, introChoices, characterHolder, startHolder, nextDay, backdrop1, gameChoices1, textbox,
            arrowHolder1, arrowHolder2, arrowHolder3, arrowHolder4, sTextbox, mbTextbox, peopleChoices, lTextbox,
            hTextbox, oTextbox, jTextbox, pTextbox, endScreen, endText;
    JLabel assistantPic, titleLabel, backdrop1Pic, hallway1Pic, hallway2Pic, hallway3Pic, classroomPic, studentHelperPic,
            principalOfficePic, libraryPic, cafeteriaPic, officePic, santiagoPic, mrBlackPic, LucyPic, HollyPic, officeLadyPic,
            JakePic, principalPic, endPic, eText;
    JTextArea intro1, intro2, intro3, intro4, aGame1, aGame2, game1, sGame1, game2, game3, mbGame1, aGame3, game4, game5,
            game6, lGame1, game7, hGame1, game8, oGame1, game9, game10, hGame2, hGame3, aGame4, aGame5, game11, jGame1,
            game12, pGame1, pGame2, pGame3, pGame4, pGame5;
    JButton next, holder1, startButton, nextDayContinue, yes, no, upArrow, downArrow, rightArrow, leftArrow, Lucy, Holly;

    Font borderFont, textFont, titleFont;
    Border whiteLine, assistantBorder, buttonBorder, santiagoBorder, mrBlackBorder, lucyBorder, hollyBorder,
            officeLadyBorder, jakeBorder, principalBorder;
    Container cont;
    GameManager gm;
    Timer t;

    nextHandler nh = new nextHandler();
    start s = new start();
    nextDayHandler ndh = new nextDayHandler();
    yesHandler yh = new yesHandler();
    noHandler noh = new noHandler();
    upHandler uh = new upHandler();
    downHandler dh = new downHandler();
    rightHandler rh = new rightHandler();
    leftHandler lh = new leftHandler();
    LucyHandler luh = new LucyHandler();
    HollyHandler hh = new HollyHandler();

    public Game(GameManager gm) {
        this.gm = gm;
        start();
    }

    public void textTimer() {
        t = new Timer(5000, e -> {
            if(timeHandlerNum == 1) {
                aTextbox.setVisible(false);
                assistantPic.setVisible(false);

                BufferedImage aimg = null;
                try {
                    aimg = ImageIO.read(new File(".//res//Santiago.png"));
                } catch (IOException f) {
                    f.printStackTrace();
                }
                assert aimg != null;
                Image saimg = aimg.getScaledInstance(characterHolder.getWidth(), characterHolder.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon assistantIcon = new ImageIcon(saimg);
                santiagoPic = new JLabel(assistantIcon);
                santiagoPic.setBounds(225, 0, 350, 600);
                characterHolder.add(santiagoPic);
                santiagoPic.setVisible(false);
                cont.add(characterHolder);

                BufferedImage bimg = null;
                try {
                    bimg = ImageIO.read(new File(".//res//Lucy.png"));
                } catch (IOException f) {
                    f.printStackTrace();
                }
                assert bimg != null;
                Image baimg = bimg.getScaledInstance(characterHolder.getWidth(), characterHolder.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon LucyIcon = new ImageIcon(baimg);
                LucyPic = new JLabel(LucyIcon);
                LucyPic.setBounds(225, 0, 350, 600);
                characterHolder.add(LucyPic);
                LucyPic.setVisible(false);
                cont.add(characterHolder);

                BufferedImage himg = null;
                try {
                    himg = ImageIO.read(new File(".//res//Holly.png"));
                } catch (IOException f) {
                    f.printStackTrace();
                }
                assert himg != null;
                Image haimg = himg.getScaledInstance(characterHolder.getWidth(), characterHolder.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon HollyIcon = new ImageIcon(haimg);
                HollyPic = new JLabel(HollyIcon);
                HollyPic.setBounds(225, 0, 350, 600);
                characterHolder.add(HollyPic);
                HollyPic.setVisible(false);
                cont.add(characterHolder);

                BufferedImage oimg = null;
                try {
                    oimg = ImageIO.read(new File(".//res//Office Lady.png"));
                } catch (IOException f) {
                    f.printStackTrace();
                }
                assert oimg != null;
                Image oaimg = oimg.getScaledInstance(characterHolder.getWidth(), characterHolder.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon OfficeIcon = new ImageIcon(oaimg);
                officeLadyPic = new JLabel(OfficeIcon);
                officeLadyPic.setBounds(225, 0, 350, 600);
                characterHolder.add(officeLadyPic);
                officeLadyPic.setVisible(false);
                cont.add(characterHolder);

                BufferedImage jimg = null;
                try {
                    jimg = ImageIO.read(new File(".//res//Jake.png"));
                } catch (IOException f) {
                    f.printStackTrace();
                }
                assert jimg != null;
                Image jaimg = jimg.getScaledInstance(characterHolder.getWidth(), characterHolder.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon JakeIcon = new ImageIcon(jaimg);
                JakePic = new JLabel(JakeIcon);
                JakePic.setBounds(225, 0, 350, 600);
                characterHolder.add(JakePic);
                JakePic.setVisible(false);
                cont.add(characterHolder);

                BufferedImage pimg = null;
                try {
                    pimg = ImageIO.read(new File(".//res//Principal.png"));
                } catch (IOException f) {
                    f.printStackTrace();
                }
                assert pimg != null;
                Image paimg = pimg.getScaledInstance(characterHolder.getWidth(), characterHolder.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon principalIcon = new ImageIcon(paimg);
                principalPic = new JLabel(principalIcon);
                principalPic.setBounds(225, 0, 350, 600);
                characterHolder.add(principalPic);
                principalPic.setVisible(false);
                cont.add(characterHolder);

                teacherLounge();
            }
            else if(timeHandlerNum == 2) {
                santiagoPic.setVisible(false);
                game2.setVisible(false);
                story = 1;
                classroom();
            }
            else if(timeHandlerNum == 4) {
                game5.setVisible(false);
                story = 3;
                hallway2();
            }
            else if(timeHandlerNum == 5) {
                HollyPic.setVisible(false);
                hTextbox.setVisible(false);
                textbox.setVisible(true);
                if(game7 != null) {
                    game7.setVisible(false);
                }
                doneHolly = true;
                gaveLunch = true;
                helpingHolly = false;
                haveLunch = false;
                classroom();
            }
            else if(timeHandlerNum == 6) {
                LucyPic.setVisible(false);
                lTextbox.setVisible(false);
                haveLunch = false;
                gaveLunch = true;
                textbox.setVisible(true);
                if(game7 != null) {
                    game7.setVisible(false);
                }
                classroom();
            }
            else if(timeHandlerNum == 7) {
                HollyPic.setVisible(false);
                hTextbox.setVisible(false);
                textbox.setVisible(true);
                if(game7 != null) {
                    game7.setVisible(false);
                }
                game9.setVisible(false);
                frontOffice();
            }
            else if(timeHandlerNum == 8) {
                helpingHolly = true;
                HollyPic.setVisible(false);
                hTextbox.setVisible(false);
                textbox.setVisible(true);
                classroom();
            }
            else if(timeHandlerNum == 10) {
                assistantPic.setVisible(false);
                aTextbox.setVisible(false);
                textbox.setVisible(false);
                story = 5;
                hallway1();
            }
            else {
                System.out.println("Hallo");
            }
        });
    }

    public void initialize() {
        borderFont = new Font("Times New Roman", Font.BOLD, 18);
        textFont = new Font("Times New Roman", Font.PLAIN, 20);

        whiteLine = BorderFactory.createLineBorder(Color.WHITE, 3);
        buttonBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        assistantBorder = BorderFactory.createTitledBorder(whiteLine, "Assistant", TitledBorder.LEFT, TitledBorder.TOP, borderFont, Color.WHITE);
        santiagoBorder = BorderFactory.createTitledBorder(whiteLine, "Santiago", TitledBorder.LEFT, TitledBorder.TOP, borderFont, Color.WHITE);
        mrBlackBorder = BorderFactory.createTitledBorder(whiteLine, "Mr. Black", TitledBorder.LEFT, TitledBorder.TOP, borderFont, Color.WHITE);
        lucyBorder = BorderFactory.createTitledBorder(whiteLine, "Lucy", TitledBorder.LEFT, TitledBorder.TOP, borderFont, Color.WHITE);
        hollyBorder = BorderFactory.createTitledBorder(whiteLine, "Holly", TitledBorder.LEFT, TitledBorder.TOP, borderFont, Color.WHITE);
        officeLadyBorder = BorderFactory.createTitledBorder(whiteLine, "Office Lady", TitledBorder.LEFT, TitledBorder.TOP, borderFont, Color.WHITE);
        jakeBorder = BorderFactory.createTitledBorder(whiteLine, "Jake", TitledBorder.LEFT, TitledBorder.TOP, borderFont, Color.WHITE);
        principalBorder = BorderFactory.createTitledBorder(whiteLine, "Principal", TitledBorder.LEFT, TitledBorder.TOP, borderFont, Color.WHITE);

        pTextbox = new JPanel();
        pTextbox.setBounds(50, 425, 700, 125);
        pTextbox.setBackground(Color.BLACK);
        pTextbox.setBorder(principalBorder);
        pTextbox.setVisible(false);
        cont.add(pTextbox);

        jTextbox = new JPanel();
        jTextbox.setBounds(50, 425, 700, 125);
        jTextbox.setBackground(Color.BLACK);
        jTextbox.setBorder(jakeBorder);
        jTextbox.setVisible(false);
        cont.add(jTextbox);

        oTextbox = new JPanel();
        oTextbox.setBounds(50, 425, 700, 125);
        oTextbox.setBackground(Color.BLACK);
        oTextbox.setBorder(officeLadyBorder);
        oTextbox.setVisible(false);
        cont.add(oTextbox);

        lTextbox = new JPanel();
        lTextbox.setBounds(50, 425, 700, 125);
        lTextbox.setBackground(Color.BLACK);
        lTextbox.setBorder(lucyBorder);
        lTextbox.setVisible(false);
        cont.add(lTextbox);

        hTextbox = new JPanel();
        hTextbox.setBounds(50, 425, 700, 125);
        hTextbox.setBackground(Color.BLACK);
        hTextbox.setBorder(hollyBorder);
        hTextbox.setVisible(false);
        cont.add(hTextbox);

        mbTextbox = new JPanel();
        mbTextbox.setBounds(50, 425, 700, 125);
        mbTextbox.setBackground(Color.BLACK);
        mbTextbox.setBorder(mrBlackBorder);
        mbTextbox.setVisible(false);
        cont.add(mbTextbox);

        sTextbox = new JPanel();
        sTextbox.setBounds(50, 425, 700, 125);
        sTextbox.setBackground(Color.BLACK);
        sTextbox.setBorder(santiagoBorder);
        sTextbox.setVisible(false);
        cont.add(sTextbox);

        textbox = new JPanel();
        textbox.setBounds(50, 425, 700, 125);
        textbox.setBackground(Color.BLACK);
        textbox.setBorder(whiteLine);
        textbox.setVisible(false);
        cont.add(textbox);

        aTextbox = new JPanel();
        aTextbox.setBounds(50, 425, 700, 125);
        aTextbox.setBackground(Color.BLACK);
        aTextbox.setBorder(assistantBorder);
        aTextbox.setVisible(false);

        introChoices = new JPanel();
        introChoices.setBounds(650, 360, 100, 60);
        introChoices.setBackground(Color.BLACK);
        introChoices.setLayout(new GridLayout(2, 1));
        cont.add(introChoices);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(textFont);
        next.setBorder(buttonBorder);
        next.addActionListener(nh);
        introChoices.add(next);

        holder1 = new JButton("***");
        holder1.setBackground(Color.BLACK);
        holder1.setForeground(Color.WHITE);
        holder1.setFont(textFont);
        holder1.setBorder(buttonBorder);
        introChoices.add(holder1);

        introChoices.setVisible(false);

        gameChoices1 = new JPanel(new GridLayout(2, 1));
        gameChoices1.setBounds(650, 360, 100, 60);
        gameChoices1.setBackground(Color.BLACK);
        gameChoices1.setVisible(false);
        cont.add(gameChoices1);

        yes = new JButton("Yes");
        yes.setBackground(Color.BLACK);
        yes.setForeground(Color.WHITE);
        yes.setFont(textFont);
        yes.setBorder(buttonBorder);
        yes.addActionListener(yh);
        gameChoices1.add(yes);

        no = new JButton("No");
        no.setBackground(Color.BLACK);
        no.setForeground(Color.WHITE);
        no.setFont(textFont);
        no.setBorder(buttonBorder);
        no.addActionListener(noh);
        gameChoices1.add(no);

        peopleChoices = new JPanel(new GridLayout(2, 1));
        peopleChoices.setBounds(650, 360, 100, 60);
        peopleChoices.setBackground(Color.BLACK);
        peopleChoices.setVisible(false);
        cont.add(peopleChoices);

        Lucy = new JButton("Lucy");
        Lucy.setBackground(Color.BLACK);
        Lucy.setForeground(Color.WHITE);
        Lucy.setFont(textFont);
        Lucy.setBorder(buttonBorder);
        Lucy.addActionListener(luh);
        peopleChoices.add(Lucy);

        Holly = new JButton("Holly");
        Holly.setBackground(Color.BLACK);
        Holly.setForeground(Color.WHITE);
        Holly.setFont(textFont);
        Holly.setBorder(buttonBorder);
        Holly.addActionListener(hh);
        peopleChoices.add(Holly);

        peopleChoices.setVisible(false);

        characterHolder = new JPanel();
        characterHolder.setBounds(175, 0, 450, 600);
        characterHolder.setBackground(Color.BLACK);
        characterHolder.setOpaque(false);
        characterHolder.setVisible(false);

        arrowHolder1 = new JPanel();
        arrowHolder1.setBounds(365, 45, 40, 40);
        arrowHolder1.setBackground(null);
        arrowHolder1.setVisible(false);
        arrowHolder1.setOpaque(false);
        cont.add(arrowHolder1);

        BufferedImage uimg = null;
        try {
            uimg = ImageIO.read(new File(".//res//Up Arrow.png"));
        } catch (IOException f) {
            f.printStackTrace();
        }
        assert uimg != null;
        Image uaimg = uimg.getScaledInstance(arrowHolder1.getWidth(), arrowHolder1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon uArrowIcon = new ImageIcon(uaimg);
        upArrow = new JButton(uArrowIcon);
        upArrow.setBackground(null);
        upArrow.setContentAreaFilled(false);
        upArrow.setFocusPainted(false);
        upArrow.setBorder(null);
        upArrow.addActionListener(uh);
        arrowHolder1.add(upArrow);

        arrowHolder2 = new JPanel();
        arrowHolder2.setBounds(365, 335, 40, 40);
        arrowHolder2.setBackground(null);
        arrowHolder2.setVisible(false);
        arrowHolder2.setOpaque(false);
        cont.add(arrowHolder2);

        BufferedImage dimg = null;
        try {
            dimg = ImageIO.read(new File(".//res//Down Arrow.png"));
        } catch (IOException f) {
            f.printStackTrace();
        }
        assert dimg != null;
        Image daimg = dimg.getScaledInstance(arrowHolder2.getWidth(), arrowHolder2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon dArrowIcon = new ImageIcon(daimg);
        downArrow = new JButton(dArrowIcon);
        downArrow.setBackground(null);
        downArrow.setContentAreaFilled(false);
        downArrow.setFocusPainted(false);
        downArrow.setBorder(null);
        downArrow.addActionListener(dh);
        arrowHolder2.add(downArrow);

        arrowHolder3 = new JPanel();
        arrowHolder3.setBounds(660, 195, 40, 40);
        arrowHolder3.setBackground(null);
        arrowHolder3.setVisible(false);
        arrowHolder3.setOpaque(false);
        cont.add(arrowHolder3);

        BufferedImage rimg = null;
        try {
            rimg = ImageIO.read(new File(".//res//Right Arrow.png"));
        } catch (IOException f) {
            f.printStackTrace();
        }
        assert rimg != null;
        Image raimg = rimg.getScaledInstance(arrowHolder3.getWidth(), arrowHolder3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon rArrowIcon = new ImageIcon(raimg);
        rightArrow = new JButton(rArrowIcon);
        rightArrow.setBackground(null);
        rightArrow.setContentAreaFilled(false);
        rightArrow.setFocusPainted(false);
        rightArrow.setBorder(null);
        rightArrow.addActionListener(rh);
        arrowHolder3.add(rightArrow);

        arrowHolder4 = new JPanel();
        arrowHolder4.setBounds(140, 195, 40, 40);
        arrowHolder4.setBackground(null);
        arrowHolder4.setVisible(false);
        arrowHolder4.setOpaque(false);
        cont.add(arrowHolder4);

        BufferedImage limg = null;
        try {
            limg = ImageIO.read(new File(".//res//Left Arrow.png"));
        } catch (IOException f) {
            f.printStackTrace();
        }
        assert limg != null;
        Image laimg = limg.getScaledInstance(arrowHolder4.getWidth(), arrowHolder4.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lArrowIcon = new ImageIcon(laimg);
        leftArrow = new JButton(lArrowIcon);
        leftArrow.setBackground(null);
        leftArrow.setContentAreaFilled(false);
        leftArrow.setFocusPainted(false);
        leftArrow.setBorder(null);
        leftArrow.addActionListener(lh);
        arrowHolder4.add(leftArrow);

        backdrop1 = new JPanel();
        backdrop1.setBounds(40, 0, 720, 405);
        backdrop1.setBackground(Color.BLACK);
        backdrop1.setOpaque(false);
        backdrop1.setVisible(false);
    }

    public void end() {
        Font titleFont2 = new Font("Times New Roman", Font.BOLD, 60);
        arrowHolder1.setVisible(false);
        arrowHolder2.setVisible(false);
        arrowHolder3.setVisible(false);
        arrowHolder4.setVisible(false);

        introChoices.setVisible(false);

        endText = new JPanel();
        endText.setBounds(0, 400, 800, 100);
        endText.setBackground(Color.BLACK);
        cont.add(endText);

        eText = new JLabel("The End!", SwingConstants.CENTER);
        eText.setFont(titleFont2);
        eText.setBackground(Color.BLACK);
        eText.setForeground(Color.WHITE);
        endText.add(eText);
        endText.setVisible(true);

        pTextbox.setVisible(false);
        principalPic.setVisible(false);
        backdrop1.setVisible(false);
        endScreen = new JPanel();
        endScreen.setBounds(0, 0, 800, 600);
        endScreen.setBackground(Color.BLACK);
        endScreen.setVisible(true);

        BufferedImage h1img = null;
        try {
            h1img = ImageIO.read(new File(".//res//Disco.png"));
        } catch (IOException f) {
            f.printStackTrace();
        }
        assert h1img != null;
        Image ha1img = h1img.getScaledInstance(endScreen.getWidth(), endScreen.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon hallway1Icon = new ImageIcon(ha1img);
        endPic = new JLabel(hallway1Icon);
        endScreen.add(endPic);
        endPic.setVisible(true);
        cont.add(endScreen);
    }

    public void start() {
        borderFont = new Font("Times New Roman", Font.BOLD, 18);
        textFont = new Font("Times New Roman", Font.PLAIN, 20);
        titleFont = new Font("Times New Roman", Font.BOLD, 55);

        mainClassroom = new JFrame();
        mainClassroom.setSize(800, 600);
        mainClassroom.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainClassroom.getContentPane().setBackground(Color.BLACK);
        mainClassroom.setLayout(null);
        cont = mainClassroom.getContentPane();

        initialize();

        titlePage = new JPanel();
        titlePage.setBackground(Color.BLACK);
        titlePage.setBounds(20, 75, 740, 100);
        titlePage.setBorder(whiteLine);
        cont.add(titlePage);

        titleLabel = new JLabel("Equity Counselor!");
        titleLabel.setFont(titleFont);
        titleLabel.setBackground(Color.BLACK);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(new EmptyBorder(10, 20, 10, 20));
        titlePage.add(titleLabel);
        titlePage.setVisible(true);

        startHolder = new JPanel(new GridLayout(1, 1));
        startHolder.setBounds(325, 325, 140, 50);
        startHolder.setBackground(Color.BLACK);
        startHolder.setBorder(buttonBorder);
        cont.add(startHolder);

        startButton = new JButton("Start");
        startButton.setFont(textFont);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(s);
        startHolder.add(startButton);

        mainClassroom.setVisible(true);
    }

    public void intro() {
        aTextbox.setVisible(true);

        intro1 = new JTextArea("Hello Mr. Counselor and welcome to the school of equity. Amelia, our last Counselor, quit recently and we’re so glad you volunteered to be her replacement!");
        intro1.setBounds(90, 450, 620, 75);
        intro1.setBackground(Color.BLACK);
        intro1.setForeground(Color.WHITE);
        intro1.setFont(textFont);
        intro1.setLineWrap(true);
        intro1.setBorder(new EmptyBorder(0, 10, 10, 0));
        aTextbox.add(intro1);
        cont.add(aTextbox);

        BufferedImage aimg = null;
        try {
            aimg = ImageIO.read(new File(".//res//Student Assistant.png"));
        } catch (IOException f) {
            f.printStackTrace();
        }
        assert aimg != null;
        Image saimg = aimg.getScaledInstance(characterHolder.getWidth(), characterHolder.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon assistantIcon = new ImageIcon(saimg);
        assistantPic = new JLabel(assistantIcon);
        assistantPic.setBounds(225, 0, 350, 600);
        characterHolder.add(assistantPic);
        cont.add(characterHolder);

        introChoices.setVisible(true);

        characterHolder.setVisible(true);

        mainClassroom.setVisible(true);
    }

    public void game() {
        aTextbox.setVisible(true);
        characterHolder.setVisible(true);
        gameChoices1.setVisible(true);
        backdrop1.setVisible(true);

        BufferedImage tlimg = null;
        try {
            tlimg = ImageIO.read(new File(".//res//Teacher's Lounge.jpg"));
        } catch (IOException f) {
            f.printStackTrace();
        }
        assert tlimg != null;
        Image tealimg = tlimg.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon teacherLIcon = new ImageIcon(tealimg);
        backdrop1Pic = new JLabel(teacherLIcon);
        backdrop1Pic.setBounds(225, 0, 350, 433);
        backdrop1.add(backdrop1Pic);
        backdrop1Pic.setVisible(false);
        cont.add(backdrop1);

        backdrop1Pic.setVisible(true);

        aGame1 = new JTextArea("Welcome back Mr. Counselor! Your first assignment is to go watch over the test going on in the classroom. Are you ready to begin?");
        aGame1.setBounds(90, 450, 620, 75);
        aGame1.setBackground(Color.BLACK);
        aGame1.setForeground(Color.WHITE);
        aGame1.setFont(textFont);
        aGame1.setLineWrap(true);
        aGame1.setVisible(true);
        aTextbox.add(aGame1);

        mainClassroom.setVisible(true);
    }

    public void teacherLounge() {
        t.stop();
        textbox.setVisible(true);
        backdrop1Pic.setVisible(true);
        arrowHolder1.setVisible(false);
        arrowHolder2.setVisible(false);
        arrowHolder3.setVisible(true);
        arrowHolder4.setVisible(false);

        up = 1;
        down = 1;
        right = 1;
        left = 1;
    }

    public void hallway1() {
        if(hallwayFirst) {
            BufferedImage h1img = null;
            try {
                h1img = ImageIO.read(new File(".//res//Hallway1.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert h1img != null;
            Image ha1img = h1img.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon hallway1Icon = new ImageIcon(ha1img);
            hallway1Pic = new JLabel(hallway1Icon);
            hallway1Pic.setBounds(225, 0, 350, 433);
            backdrop1.add(hallway1Pic);
            hallway1Pic.setVisible(false);
            cont.add(backdrop1);
            hallwayFirst = false;
        }

        if(doneHolly & gaveLunch & story<5) {
            story = 4;
            t.stop();
            hallway1Pic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            assistantPic.setVisible(true);
            textbox.setVisible(false);
            aTextbox.setVisible(true);
            introChoices.setVisible(true);
            aGame3.setVisible(false);

            aGame4 = new JTextArea("Ah! Mr.Counselor! Just the man I was looking for! It seems you've helped Lucy and Holly. Very nice! Now, I have one final job for you today. In the Library, there are a stack of textbooks.");
            aGame4.setBounds(90, 450, 620, 75);
            aGame4.setBackground(Color.BLACK);
            aGame4.setForeground(Color.WHITE);
            aGame4.setFont(textFont);
            aGame4.setLineWrap(true);
            aGame4.setVisible(true);
            aTextbox.add(aGame4);
            nextHandler = 12;
        }
        else {
            hallway1Pic.setVisible(true);
            arrowHolder1.setVisible(true);
            arrowHolder2.setVisible(true);
            arrowHolder3.setVisible(true);
            arrowHolder4.setVisible(true);

            up = 2;
            down = 2;
            right = 2;
            left = 2;
        }
    }

    public void hallway2(){
        if(hallway2First) {
            BufferedImage h2img = null;
            try {
                h2img = ImageIO.read(new File(".//res//Hallway2.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert h2img != null;
            Image ha2img = h2img.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon hallway2Icon = new ImageIcon(ha2img);
            hallway2Pic = new JLabel(hallway2Icon);
            hallway2Pic.setBounds(225, 0, 350, 433);
            backdrop1.add(hallway2Pic);
            hallway2Pic.setVisible(false);
            cont.add(backdrop1);
            hallway2First = false;
        }

        if(story == 2) {
            hallway2Pic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            game4 = new JTextArea("*As you were jotting down what Mr.Black said on your way to the front office, you didn't notice that someone was in front of you and crash into them.*");
            game4.setBounds(90, 450, 620, 75);
            game4.setBackground(Color.BLACK);
            game4.setForeground(Color.WHITE);
            game4.setFont(textFont);
            game4.setLineWrap(true);
            game4.setVisible(true);
            textbox.add(game4);
            nextHandler = 4;
            introChoices.setVisible(true);
        }
        else {
            t.stop();
            hallway2Pic.setVisible(true);
            arrowHolder1.setVisible(true);
            arrowHolder2.setVisible(true);
            arrowHolder3.setVisible(true);
            arrowHolder4.setVisible(true);

            up = 4;
            down = 4;
            right = 4;
            left = 4;
        }
    }

    public void hallway3() {
        if(hallway3First) {
            BufferedImage h2img = null;
            try {
                h2img = ImageIO.read(new File(".//res//Hallway3.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert h2img != null;
            Image ha2img = h2img.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon hallway2Icon = new ImageIcon(ha2img);
            hallway3Pic = new JLabel(hallway2Icon);
            hallway3Pic.setBounds(225, 0, 350, 433);
            backdrop1.add(hallway3Pic);
            hallway3Pic.setVisible(false);
            cont.add(backdrop1);
            hallway3First = false;
        }

        hallway3Pic.setVisible(true);
        arrowHolder1.setVisible(true);
        arrowHolder2.setVisible(true);
        arrowHolder3.setVisible(false);
        arrowHolder4.setVisible(true);

        up = 5;
        down = 5;
        right = 5;
        left = 5;
    }

    public void classroom() {
        if(classroomFirst) {
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);
            BufferedImage c1img = null;
            try {
                c1img = ImageIO.read(new File(".//res//Classroom.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert c1img != null;
            Image cla1img = c1img.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon hallway1Icon = new ImageIcon(cla1img);
            classroomPic = new JLabel(hallway1Icon);
            classroomPic.setBounds(225, 0, 350, 433);
            backdrop1.add(classroomPic);
            classroomPic.setVisible(false);
            cont.add(backdrop1);

            classroomPic.setVisible(true);
            game1 = new JTextArea("*As you enter the classroom, you see someone coming towards you.*");
            game1.setBounds(90, 450, 620, 75);
            game1.setBackground(Color.BLACK);
            game1.setForeground(Color.WHITE);
            game1.setFont(textFont);
            game1.setLineWrap(true);
            game1.setVisible(true);
            textbox.add(game1);

            nextHandler = 1;
            introChoices.setVisible(true);
            classroomFirst = false;
        }
        else {
            t.stop();

            classroomPic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(true);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            up = 3;
            down = 3;
            right = 3;
            left = 3;
        }

        if(story == 6) {
            classroomPic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            textbox.setVisible(false);
            jTextbox.setVisible(true);
            JakePic.setVisible(true);
            introChoices.setVisible(true);

            jGame1 = new JTextArea("A-are these textbooks? T-thank you so much M-mr. Counselor! I'll cherish them forever! A-also, the principal told us to tell you to meet up with him!");
            jGame1.setBounds(90, 450, 620, 75);
            jGame1.setBackground(Color.BLACK);
            jGame1.setForeground(Color.WHITE);
            jGame1.setFont(textFont);
            jGame1.setLineWrap(true);
            jGame1.setVisible(true);
            jTextbox.add(jGame1);

            nextHandler = 15;
        }

        if(story>=3) {
            if(!helpingHolly & !doneHolly) {
                classroomPic.setVisible(true);
                arrowHolder1.setVisible(false);
                arrowHolder2.setVisible(false);
                arrowHolder3.setVisible(false);
                arrowHolder4.setVisible(false);

                if(haveLunch) {
                    game6 = new JTextArea("*You can help both Lucy and Holly. Who would you like to help first?*");
                    game6.setBounds(90, 450, 620, 75);
                    game6.setBackground(Color.BLACK);
                    game6.setForeground(Color.WHITE);
                    game6.setFont(textFont);
                    game6.setLineWrap(true);
                    game6.setVisible(true);
                    textbox.add(game6);

                    peopleChoices.setVisible(true);
                }
                else if(helpingHolly) {
                    t.stop();

                    classroomPic.setVisible(true);
                    arrowHolder1.setVisible(false);
                    arrowHolder2.setVisible(true);
                    arrowHolder3.setVisible(false);
                    arrowHolder4.setVisible(false);

                    up = 3;
                    down = 3;
                    right = 3;
                    left = 3;
                }
                else{
                    helpingHolly = true;
                    textbox.setVisible(false);
                    HollyPic.setVisible(true);
                    hTextbox.setVisible(true);
                    helpingHolly = true;

                    hGame1 = new JTextArea("Mr. Counselor, I can't focus on reading because of all the noise around here. Could you please take me to a quiet spot so I don't get distracted? I'll follow right behind you!");
                    hGame1.setBounds(90, 450, 620, 75);
                    hGame1.setBackground(Color.BLACK);
                    hGame1.setForeground(Color.WHITE);
                    hGame1.setFont(textFont);
                    hGame1.setLineWrap(true);
                    hGame1.setVisible(true);
                    hTextbox.add(hGame1);

                    timeHandlerNum = 8;
                    textTimer();
                    t.start();
                }
            }
            else if(haveLunch) {
                if(helpingHolly) {
                    t.stop();

                    classroomPic.setVisible(true);
                    arrowHolder1.setVisible(false);
                    arrowHolder2.setVisible(true);
                    arrowHolder3.setVisible(false);
                    arrowHolder4.setVisible(false);

                    up = 3;
                    down = 3;
                    right = 3;
                    left = 3;
                }
                else {
                    textbox.setVisible(false);
                    peopleChoices.setVisible(false);
                    LucyPic.setVisible(true);
                    lTextbox.setVisible(true);

                    lGame1 = new JTextArea("Thanks for getting me my lunch Mr. Counselor! I thought I was going to have to go without eating today, I'm very thankful for your help!");
                    lGame1.setBounds(90, 450, 620, 75);
                    lGame1.setBackground(Color.BLACK);
                    lGame1.setForeground(Color.WHITE);
                    lGame1.setFont(textFont);
                    lGame1.setLineWrap(true);
                    lGame1.setVisible(true);
                    lTextbox.add(lGame1);
                    haveLunch = false;
                    gaveLunch = true;

                    timeHandlerNum = 6;
                    textTimer();
                    t.start();
                }
            }
            else {
                t.stop();

                classroomPic.setVisible(true);
                arrowHolder1.setVisible(false);
                arrowHolder2.setVisible(true);
                arrowHolder3.setVisible(false);
                arrowHolder4.setVisible(false);

                up = 3;
                down = 3;
                right = 3;
                left = 3;
            }
        }
    }

    public void studentHelper() {
        if(studentHelperFirst) {
            BufferedImage c1img = null;
            try {
                c1img = ImageIO.read(new File(".//res//Student Helper.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert c1img != null;
            Image cla1img = c1img.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon hallway1Icon = new ImageIcon(cla1img);
            studentHelperPic = new JLabel(hallway1Icon);
            studentHelperPic.setBounds(225, 0, 350, 433);
            backdrop1.add(studentHelperPic);
            studentHelperPic.setVisible(false);
            cont.add(backdrop1);
            studentHelperFirst = false;
        }
        if(helpingHolly) {
            studentHelperPic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            gameChoices1.setVisible(true);
            place = 2;

            game10 = new JTextArea("*This place seems quiet. Would you like to leave Holly here?*");
            game10.setBounds(90, 450, 620, 75);
            game10.setBackground(Color.BLACK);
            game10.setForeground(Color.WHITE);
            game10.setFont(textFont);
            game10.setLineWrap(true);
            game10.setVisible(true);
            textbox.add(game10);
        }
        else {
            studentHelperPic.setVisible(true);
            arrowHolder1.setVisible(true);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            up = 6;
            down = 6;
            right = 6;
            left = 6;
        }
    }

    public void principalOffice() {
        if(principalFirst) {
            BufferedImage c1img = null;
            try {
                c1img = ImageIO.read(new File(".//res//Principal Office.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert c1img != null;
            Image cla1img = c1img.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon hallway1Icon = new ImageIcon(cla1img);
            principalOfficePic = new JLabel(hallway1Icon);
            principalOfficePic.setBounds(225, 0, 350, 433);
            backdrop1.add(principalOfficePic);
            principalOfficePic.setVisible(false);
            cont.add(backdrop1);
            principalFirst = false;
        }

        if(story == 7) {
            principalOfficePic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            textbox.setVisible(false);
            pTextbox.setVisible(true);
            principalPic.setVisible(true);
            introChoices.setVisible(true);

            pGame1 = new JTextArea("Hooh! So you're the new Counselor! I've heard great things about you, you know. So many kids already like you on the first day. I gotta say, I'm jealous. However, I'm also glad that such a talent is coming to our team!");
            pGame1.setBounds(90, 450, 620, 75);
            pGame1.setBackground(Color.BLACK);
            pGame1.setForeground(Color.WHITE);
            pGame1.setFont(textFont);
            pGame1.setLineWrap(true);
            pGame1.setVisible(true);
            pTextbox.add(pGame1);
            nextHandler = 20;
        }
        else {
            principalOfficePic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(true);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            up = 7;
            down = 7;
            right = 7;
            left = 7;
        }
    }

    public void library() {
        if(libraryFirst) {
            BufferedImage c1img = null;
            try {
                c1img = ImageIO.read(new File(".//res//Library.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert c1img != null;
            Image cla1img = c1img.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon hallway1Icon = new ImageIcon(cla1img);
            libraryPic = new JLabel(hallway1Icon);
            libraryPic.setBounds(225, 0, 350, 433);
            backdrop1.add(libraryPic);
            libraryPic.setVisible(false);
            cont.add(backdrop1);
            libraryFirst = false;
        }
        if(story == 5) {
            libraryPic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);
            introChoices.setVisible(true);

            game11 = new JTextArea("*After hunting for the stack of textbooks, you finally find them hidden in a corner. You grab the heavy load of books and carry them back to the classroom to deliver them to Jake and wrapping up your first day.*");
            game11.setBounds(90, 450, 620, 75);
            game11.setBackground(Color.BLACK);
            game11.setForeground(Color.WHITE);
            game11.setFont(textFont);
            game11.setLineWrap(true);
            game11.setVisible(true);
            textbox.add(game11);
            textbox.setVisible(true);

            nextHandler = 13;
        }
        else if(helpingHolly) {
            libraryPic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            gameChoices1.setVisible(true);
            place = 1;

            game10 = new JTextArea("*This place seems quiet. Would you like to leave Holly here?*");
            game10.setBounds(90, 450, 620, 75);
            game10.setBackground(Color.BLACK);
            game10.setForeground(Color.WHITE);
            game10.setFont(textFont);
            game10.setLineWrap(true);
            game10.setVisible(true);
            textbox.add(game10);
        }
        else {
            libraryPic.setVisible(true);
            arrowHolder1.setVisible(true);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            up = 8;
            down = 8;
            right = 8;
            left = 8;
        }
    }

    public void cafeteria() {
        if(cafeteriaFirst) {
            BufferedImage aimg = null;
            try {
                aimg = ImageIO.read(new File(".//res//Mr Black.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert aimg != null;
            Image saimg = aimg.getScaledInstance(characterHolder.getWidth(), characterHolder.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon assistantIcon = new ImageIcon(saimg);
            mrBlackPic = new JLabel(assistantIcon);
            mrBlackPic.setBounds(225, 0, 350, 600);
            characterHolder.add(mrBlackPic);
            mrBlackPic.setVisible(false);
            cont.add(characterHolder);

            BufferedImage c1img = null;
            try {
                c1img = ImageIO.read(new File(".//res//Cafeteria.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert c1img != null;
            Image cla1img = c1img.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon hallway1Icon = new ImageIcon(cla1img);
            cafeteriaPic = new JLabel(hallway1Icon);
            cafeteriaPic.setBounds(225, 0, 350, 433);
            backdrop1.add(cafeteriaPic);
            cafeteriaPic.setVisible(false);
            cont.add(backdrop1);
            cafeteriaFirst = false;
        }

        if(story == 1) {
            cafeteriaPic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            game3 = new JTextArea("*After entering the lunch room, you easily find Mr. Black and explain to him the situation.*");
            game3.setBounds(90, 450, 620, 75);
            game3.setBackground(Color.BLACK);
            game3.setForeground(Color.WHITE);
            game3.setFont(textFont);
            game3.setLineWrap(true);
            game3.setVisible(true);
            textbox.add(game3);

            introChoices.setVisible(true);
            nextHandler = 3;
        }
        else{
            t.stop();

            cafeteriaPic.setVisible(true);
            arrowHolder1.setVisible(true);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            up = 9;
            down = 9;
            right = 9;
            left = 9;
        }
    }

    public void frontOffice() {
        if(officeFirst) {
            BufferedImage c1img = null;
            try {
                c1img = ImageIO.read(new File(".//res//Front Office.png"));
            } catch (IOException f) {
                f.printStackTrace();
            }
            assert c1img != null;
            Image cla1img = c1img.getScaledInstance(backdrop1.getWidth(), backdrop1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon hallway1Icon = new ImageIcon(cla1img);
            officePic = new JLabel(hallway1Icon);
            officePic.setBounds(225, 0, 350, 433);
            backdrop1.add(officePic);
            officePic.setVisible(false);
            cont.add(backdrop1);
            officeFirst = false;
        }

        if(story == 3 & !haveLunch) {
            officePic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(false);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            game8 = new JTextArea("*Making sure not to forget, you make your way to the front office to pick up Lucy's lunch.*");
            game8.setBounds(90, 450, 620, 75);
            game8.setBackground(Color.BLACK);
            game8.setForeground(Color.WHITE);
            game8.setFont(textFont);
            game8.setLineWrap(true);
            game8.setVisible(true);
            textbox.add(game8);

            haveLunch = true;
            introChoices.setVisible(true);
            nextHandler = 9;
        }
        else {
            t.stop();

            officePic.setVisible(true);
            arrowHolder1.setVisible(false);
            arrowHolder2.setVisible(true);
            arrowHolder3.setVisible(false);
            arrowHolder4.setVisible(false);

            up = 10;
            down = 10;
            right = 10;
            left = 10;
        }
    }

    public class nextHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(nextHandler == 1) {
                nextHandler = 2;
                textbox.setVisible(false);
                santiagoPic.setVisible(true);
                sTextbox.setVisible(true);
                sGame1 = new JTextArea("Me don’t err…entiendo la prueba ( I don’t understand my test)");
                sGame1.setBounds(90, 450, 620, 75);
                sGame1.setBackground(Color.BLACK);
                sGame1.setForeground(Color.WHITE);
                sGame1.setFont(textFont);
                sGame1.setLineWrap(true);
                sGame1.setVisible(true);
                sTextbox.add(sGame1);
            }
            else if(nextHandler == 2) {
                sTextbox.setVisible(false);
                textbox.setVisible(true);
                game1.setVisible(false);
                introChoices.setVisible(false);

                game2 = new JTextArea("*You look down to the assistant's notes: Show equity and find someone to \nhelp Santiago read his test. Ms. Black, one of ESL teachers, should be in the \nCafeteria.*");
                game2.setBounds(90, 450, 620, 75);
                game2.setBackground(Color.BLACK);
                game2.setForeground(Color.WHITE);
                game2.setFont(textFont);
                game2.setLineWrap(true);
                game2.setVisible(true);
                textbox.add(game2);

                timeHandlerNum = 2;
                textTimer();
                t.start();
            }
            else if(nextHandler == 3) {
                textbox.setVisible(false);
                mrBlackPic.setVisible(true);
                mbTextbox.setVisible(true);

                mbGame1 = new JTextArea("Oh I see...Thank you for telling me. Also, I need you to pick up Lucy’s lunch from the front office since her mom is bringing it later today. She forgot it and we can’t give her anything from the school since she’s diabetic.");
                mbGame1.setBounds(90, 450, 620, 75);
                mbGame1.setBackground(Color.BLACK);
                mbGame1.setForeground(Color.WHITE);
                mbGame1.setFont(textFont);
                mbGame1.setLineWrap(true);
                mbGame1.setVisible(true);
                mbTextbox.add(mbGame1);

                nextHandler = 8;
            }
            else if(nextHandler == 4) {
                textbox.setVisible(false);
                assistantPic.setVisible(true);
                aTextbox.setVisible(true);
                aGame2.setVisible(false);

                aGame3 = new JTextArea("Oww...Oh Mr.Counselor! Didn't expect to see you here! Oh while you're here, I need you to find Holly a quiet place to work because of her ADHD! Ok, Bye!");
                aGame3.setBounds(90, 450, 620, 75);
                aGame3.setBackground(Color.BLACK);
                aGame3.setForeground(Color.WHITE);
                aGame3.setFont(textFont);
                aGame3.setLineWrap(true);
                aGame3.setVisible(true);
                aTextbox.add(aGame3);

                nextHandler = 5;
            }
            else if(nextHandler == 5) {
                introChoices.setVisible(false);
                assistantPic.setVisible(false);
                aTextbox.setVisible(false);
                textbox.setVisible(true);
                game4.setVisible(false);

                game5 = new JTextArea("*'Well that was quick!' you think as another thing is added to your list of things to finish today.*");
                game5.setBounds(90, 450, 620, 75);
                game5.setBackground(Color.BLACK);
                game5.setForeground(Color.WHITE);
                game5.setFont(textFont);
                game5.setLineWrap(true);
                game5.setVisible(true);
                textbox.add(game5);

                timeHandlerNum = 4;
                textTimer();
                t.start();
            }
            else if(nextHandler == 6) {
                LucyPic.setVisible(false);
                lTextbox.setVisible(false);
                textbox.setVisible(true);
                game6.setVisible(false);
                haveLunch = false;
                gaveLunch = true;

                game7 = new JTextArea("*Now that you've handed Lucy her lunch, you realize that you need to help Holly.*");
                game7.setBounds(90, 450, 620, 75);
                game7.setBackground(Color.BLACK);
                game7.setForeground(Color.WHITE);
                game7.setFont(textFont);
                game7.setLineWrap(true);
                game7.setVisible(true);
                textbox.add(game7);

                nextHandler = 7;
            }
            else if(nextHandler == 7) {
                game7.setVisible(false);
                helpingHolly = true;
                textbox.setVisible(false);
                HollyPic.setVisible(true);
                hTextbox.setVisible(true);
                introChoices.setVisible(false);
                helpingHolly = true;
                game6.setVisible(false);

                hGame1 = new JTextArea("Mr. Counselor, I can't focus on reading because of all the noise around here. Could you please take me to a quiet spot so I don't get distracted? I'll follow right behind you!");
                hGame1.setBounds(90, 450, 620, 75);
                hGame1.setBackground(Color.BLACK);
                hGame1.setForeground(Color.WHITE);
                hGame1.setFont(textFont);
                hGame1.setLineWrap(true);
                hGame1.setVisible(true);
                hTextbox.add(hGame1);

                timeHandlerNum = 8;
                textTimer();
                t.start();
            }
            else if(nextHandler == 8) {
                introChoices.setVisible(false);
                mrBlackPic.setVisible(false);
                mbTextbox.setVisible(false);
                textbox.setVisible(true);
                game3.setVisible(false);
                story = 2;
                cafeteria();
            }
            else if(nextHandler == 9) {
                textbox.setVisible(false);
                officeLadyPic.setVisible(true);
                oTextbox.setVisible(true);

                oGame1 = new JTextArea("Hello Mr.Counselor! You're here to pick up Lucy's lunch? Perfect! Her mom just came by and dropped it off. Here you go!");
                oGame1.setBounds(90, 450, 620, 75);
                oGame1.setBackground(Color.BLACK);
                oGame1.setForeground(Color.WHITE);
                oGame1.setFont(textFont);
                oGame1.setLineWrap(true);
                oGame1.setVisible(true);
                oTextbox.add(oGame1);

                nextHandler = 10;
            }
            else if(nextHandler == 10) {
                oTextbox.setVisible(false);
                officeLadyPic.setVisible(false);
                textbox.setVisible(true);
                game8.setVisible(false);
                introChoices.setVisible(false);

                game9 = new JTextArea("*You quickly thank her as you grab the bag and head over to the classroom to give it to Lucy.*");
                game9.setBounds(90, 450, 620, 75);
                game9.setBackground(Color.BLACK);
                game9.setForeground(Color.WHITE);
                game9.setFont(textFont);
                game9.setLineWrap(true);
                game9.setVisible(true);
                textbox.add(game9);

                timeHandlerNum = 7;
                textTimer();
                t.start();
            }
            else if(nextHandler == 11) {
                HollyPic.setVisible(false);
                hTextbox.setVisible(false);
                textbox.setVisible(true);
                introChoices.setVisible(false);
                helpingHolly = false;
                game10.setVisible(false);
                if(place == 1) {
                    library();
                }
                else if(place == 2) {
                    studentHelper();
                }
            }
            else if(nextHandler == 12) {
                aGame4.setVisible(false);
                introChoices.setVisible(false);

                aGame5 = new JTextArea("These are meant for Jake, who is from an unfortunate background and can't buy those books. Please deliver the books to him in the classroom after you grab them.");
                aGame5.setBounds(90, 450, 620, 75);
                aGame5.setBackground(Color.BLACK);
                aGame5.setForeground(Color.WHITE);
                aGame5.setFont(textFont);
                aGame5.setLineWrap(true);
                aGame5.setVisible(true);
                aTextbox.add(aGame5);

                timeHandlerNum = 10;
                textTimer();
                t.start();
            }
            else if(nextHandler == 13) {
                story = 6;
                game11.setVisible(false);
                introChoices.setVisible(false);
                library();
            }
            else if(nextHandler == 15) {
                JakePic.setVisible(false);
                jTextbox.setVisible(false);
                textbox.setVisible(true);

                game12 = new JTextArea("*The principal? I wonder why he wants to meet with me of all people! I'm just a new recruit after all!*");
                game12.setBounds(90, 450, 620, 75);
                game12.setBackground(Color.BLACK);
                game12.setForeground(Color.WHITE);
                game12.setFont(textFont);
                game12.setLineWrap(true);
                game12.setVisible(true);
                textbox.add(game12);

                nextHandler = 16;
            }
            else if(nextHandler == 16) {
                introChoices.setVisible(false);
                game12.setVisible(false);
                story = 7;
                classroom();
            }
            else if(nextHandler == 20) {
                pGame1.setVisible(false);

                pGame2 = new JTextArea("Not many people know the meaning of equity these days since it's getting harder and harder to find these days.. But seeing the work you did, and seeing the happy smiles on the children, it truly seemed as if they were all equal.");
                pGame2.setBounds(90, 450, 620, 75);
                pGame2.setBackground(Color.BLACK);
                pGame2.setForeground(Color.WHITE);
                pGame2.setFont(textFont);
                pGame2.setLineWrap(true);
                pGame2.setVisible(true);
                pTextbox.add(pGame2);
                nextHandler = 21;
            }
            else if(nextHandler == 21) {
                pGame2.setVisible(false);

                pGame3 = new JTextArea("From the bottom of my heart, thank you. Thank you from the kids who have language barriers, from the kids who have physical ailments, mental ailments, and even from kids in poverty.");
                pGame3.setBounds(90, 450, 620, 75);
                pGame3.setBackground(Color.BLACK);
                pGame3.setForeground(Color.WHITE);
                pGame3.setFont(textFont);
                pGame3.setLineWrap(true);
                pGame3.setVisible(true);
                pTextbox.add(pGame3);
                nextHandler = 22;
            }
            else if(nextHandler == 22) {
                pGame3.setVisible(false);

                pGame4 = new JTextArea("And finally, from me. Thank you. Thank you for making my school a better place. Thank you for helping my kids feel included. And finally, thank you for letting me see such a happy sight again.");
                pGame4.setBounds(90, 450, 620, 75);
                pGame4.setBackground(Color.BLACK);
                pGame4.setForeground(Color.WHITE);
                pGame4.setFont(textFont);
                pGame4.setLineWrap(true);
                pGame4.setVisible(true);
                pTextbox.add(pGame4);
                nextHandler = 23;
            }
            else if(nextHandler == 23) {
                pGame4.setVisible(false);

                pGame5 = new JTextArea("Now then, with all the feelings out of the way, we're having a disco party tonight! And you're invited! Let's party! WOOO!");
                pGame5.setBounds(90, 450, 620, 75);
                pGame5.setBackground(Color.BLACK);
                pGame5.setForeground(Color.WHITE);
                pGame5.setFont(textFont);
                pGame5.setLineWrap(true);
                pGame5.setVisible(true);
                pTextbox.add(pGame5);
                nextHandler = 24;
            }
            else if(nextHandler == 24) {
                end();
            }
            else if(buttonPressed & nextOne) {
                intro2.setVisible(false);

                intro3 = new JTextArea("Remember, treat people with equity. Equity is recognizing that \neveryone has different needs and giving them the resources they need to succeed like everyone else.");
                intro3.setBounds(90, 450, 620, 75);
                intro3.setBackground(Color.BLACK);
                intro3.setForeground(Color.WHITE);
                intro3.setFont(textFont);
                intro3.setLineWrap(true);
                intro3.setVisible(true);
                aTextbox.add(intro3);

                buttonPressed = false;
            }
            else if(!buttonPressed & nextOne) {
                intro3.setVisible(false);

                intro4 = new JTextArea("First, go rest up in the Teacher’s lounge. You’ll start working here from \ntomorrow onward.");
                intro4.setBounds(90, 450, 620, 75);
                intro4.setBackground(Color.BLACK);
                intro4.setForeground(Color.WHITE);
                intro4.setFont(textFont);
                intro4.setLineWrap(true);
                intro4.setVisible(true);
                aTextbox.add(intro4);

                nextOne = false;
                buttonPressed = true;
            }
            else //noinspection ConstantConditions
                if(buttonPressed & !nextOne) {
                aTextbox.setVisible(false);
                characterHolder.setVisible(false);
                introChoices.setVisible(false);

                nextDay = new JPanel(new GridLayout(1, 1));
                nextDay.setBounds(0, 0, 800, 600);
                nextDay.setBackground(Color.BLACK);
                cont.add(nextDay);

                nextDayContinue = new JButton("The Next Day...(click)");
                nextDayContinue.setBackground(Color.BLACK);
                nextDayContinue.setForeground(Color.WHITE);
                nextDayContinue.setFont(titleFont);
                nextDayContinue.addActionListener(ndh);
                nextDay.add(nextDayContinue);
            }
            else {
                buttonPressed = true;
                nextOne = true;
                intro1.setVisible(false);

                intro2 = new JTextArea("I’ve given you a list of all the work Amelia was supposed to do. Please finish them as fast as you can.");
                intro2.setBounds(90, 450, 620, 75);
                intro2.setBackground(Color.BLACK);
                intro2.setForeground(Color.WHITE);
                intro2.setFont(textFont);
                intro2.setLineWrap(true);
                intro2.setVisible(true);
                aTextbox.add(intro2);
            }
        }
    }

    public class start implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            titlePage.setVisible(false);
            startHolder.setVisible(false);
            intro();
        }
    }

    public class nextDayHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nextDay.setVisible(false);
            intro4.setVisible(false);
            game();
        }
    }

    public class yesHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(first) {
                first = false;
                gameChoices1.setVisible(false);
                timeHandlerNum = 1;
                aGame1.setVisible(false);

                aGame2 = new JTextArea("Alright! Please head over to the classroom now to watch over the kids taking the test. (The game hasn't crashed here, there's just a five second timer. There will be more of these timers.)");
                aGame2.setBounds(90, 450, 620, 75);
                aGame2.setBackground(Color.BLACK);
                aGame2.setForeground(Color.WHITE);
                aGame2.setFont(textFont);
                aGame2.setLineWrap(true);
                aGame2.setVisible(true);
                aTextbox.add(aGame2);

                timeHandlerNum = 1;
                textTimer();
                t.start();
            }
            else {
                gameChoices1.setVisible(false);
                hTextbox.setVisible(true);
                if(hGame1 != null) {
                    hGame1.setVisible(false);
                }
                HollyPic.setVisible(true);
                introChoices.setVisible(true);
                if(place == 1) {
                    hGame2 = new JTextArea("Thank you so much Mr.Counselor! This place is perfect! I can finally read my book in peace now! Oh right, the assistant told me to tell you to meet her at the first hallway!");
                    hGame2.setBounds(90, 450, 620, 75);
                    hGame2.setBackground(Color.BLACK);
                    hGame2.setForeground(Color.WHITE);
                    hGame2.setFont(textFont);
                    hGame2.setLineWrap(true);
                    hGame2.setVisible(true);
                    hTextbox.add(hGame2);

                    doneHolly = true;
                    nextHandler = 11;
                }
                else if(place == 2) {
                    hGame3 = new JTextArea("Thank you Mr.Counselor. This area is really quiet. I should be able to read my book here without any distractions! Oh right, the assistant told me to tell you to meet her at the first hallway!");
                    hGame3.setBounds(90, 450, 620, 75);
                    hGame3.setBackground(Color.BLACK);
                    hGame3.setForeground(Color.WHITE);
                    hGame3.setFont(textFont);
                    hGame3.setLineWrap(true);
                    hGame3.setVisible(true);
                    hTextbox.add(hGame3);

                    doneHolly = true;
                    nextHandler = 11;
                }
                else{
                    System.out.println("error");
                }
            }
        }
    }

    public class noHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(first) {
                first = false;
                gameChoices1.setVisible(false);
                timeHandlerNum = 1;
                aGame1.setVisible(false);

                aGame2 = new JTextArea("That's fine, everyone's nervous on their first day. Please head to the classroom whenever you are ready. (The game hasn't crashed here, there's just a five second timer. There will be more of these timers.)");
                aGame2.setBounds(90, 450, 620, 75);
                aGame2.setBackground(Color.BLACK);
                aGame2.setForeground(Color.WHITE);
                aGame2.setFont(textFont);
                aGame2.setLineWrap(true);
                aGame2.setVisible(true);
                aTextbox.add(aGame2);

                timeHandlerNum = 1;
                textTimer();
                t.start();
            }
            else {
                gameChoices1.setVisible(false);
                game10.setVisible(false);
                if(place == 1) {
                    libraryPic.setVisible(false);
                    hallway3();
                }
                else if(place == 2) {
                    studentHelperPic.setVisible(false);
                    hallway1();
                }
            }
        }
    }

    public class upHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(up == 2) {
                hallway1Pic.setVisible(false);
                classroom();
            }
            else if(up == 4) {
                hallway2Pic.setVisible(false);
                frontOffice();
            }
            else if(up == 5) {
                hallway3Pic.setVisible(false);
                principalOffice();
            }
            else if(up == 6) {
                studentHelperPic.setVisible(false);
                hallway1();
            }
            else if(up == 8) {
                libraryPic.setVisible(false);
                hallway3();
            }
            else if(up == 9) {
                cafeteriaPic.setVisible(false);
                hallway2();
            }
        }
    }

    public class downHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(down == 2) {
                hallway1Pic.setVisible(false);
                studentHelper();
            }
            else if(down == 3) {
                classroomPic.setVisible(false);
                hallway1();
            }
            else if(down == 4) {
                hallway2Pic.setVisible(false);
                cafeteria();
            }
            else if(down == 5) {
                hallway3Pic.setVisible(false);
                library();
            }
            else if(down == 7) {
                principalOfficePic.setVisible(false);
                hallway3();
            }
            else if(down == 10) {
                officePic.setVisible(false);
                hallway2();
            }
        }
    }

    public class rightHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(right == 1) {
                backdrop1Pic.setVisible(false);
                hallway1();
            }
            else if(right == 2) {
                hallway1Pic.setVisible(false);
                hallway2();
            }
            else if(right == 4) {
                hallway2Pic.setVisible(false);
                hallway3();
            }
        }
    }

    public class leftHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(left == 2) {
                hallway1Pic.setVisible(false);
                teacherLounge();
            }
            else if(left == 4) {
                hallway2Pic.setVisible(false);
                hallway1();
            }
            else if(left == 5) {
                hallway3Pic.setVisible(false);
                hallway2();
            }
        }
    }

    public class LucyHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textbox.setVisible(false);
            peopleChoices.setVisible(false);
            LucyPic.setVisible(true);
            lTextbox.setVisible(true);
            introChoices.setVisible(true);
            game6.setVisible(false);

            lGame1 = new JTextArea("Thanks for getting me my lunch Mr. Counselor! I thought I was going to have to go without eating today, I'm very thankful for your help!");
            lGame1.setBounds(90, 450, 620, 75);
            lGame1.setBackground(Color.BLACK);
            lGame1.setForeground(Color.WHITE);
            lGame1.setFont(textFont);
            lGame1.setLineWrap(true);
            lGame1.setVisible(true);
            lTextbox.add(lGame1);

            nextHandler = 6;
        }
    }

    public class HollyHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            helpingHolly = true;
            textbox.setVisible(false);
            HollyPic.setVisible(true);
            hTextbox.setVisible(true);
            peopleChoices.setVisible(false);
            helpingHolly = true;
            game6.setVisible(false);

            hGame1 = new JTextArea("Mr. Counselor, I can't focus on reading because of all the noise around here. Could you please take me to a quiet spot so I don't get distracted? I'll follow right behind you!");
            hGame1.setBounds(90, 450, 620, 75);
            hGame1.setBackground(Color.BLACK);
            hGame1.setForeground(Color.WHITE);
            hGame1.setFont(textFont);
            hGame1.setLineWrap(true);
            hGame1.setVisible(true);
            hTextbox.add(hGame1);

            timeHandlerNum = 8;
            textTimer();
            t.start();
        }
    }
}