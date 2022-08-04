import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.lang.Math;
/**
 * Write a description of class question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends Actor
{
    /**
     * Act - do whatever the question wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private HashMap<String, Integer> answer_dict;
    public Integer right_ans;
    private int timer;
    private String text = "";
    public Question(String operation){
        int a1 = Greenfoot.getRandomNumber(100);
        int a2 = Greenfoot.getRandomNumber(100) + 1;
        System.out.println(operation);
        if (operation.equals("+")) {
            this.right_ans = a1 + a2;
        } else if (operation.equals("-")){
            this.right_ans = a1 - a2;
        }
        else if (operation.equals("x")){
            this.right_ans = a1 * a2;
        }
        else if (operation.equals("/")){
            a1 = a2 * (Greenfoot.getRandomNumber(15) + 1);
            this.right_ans = a1 / a2;
        }
        Integer ans_1 = right_ans;
        Integer ans_2 = right_ans - Greenfoot.getRandomNumber(Math.abs(right_ans+10) * 3 + 1);
        Integer ans_3 = right_ans + Greenfoot.getRandomNumber(Math.abs(right_ans+10) * 4 + 1);
        Integer ans_4 = right_ans - Greenfoot.getRandomNumber(Math.abs(right_ans+10) * 5 + 1);
        ArrayList<Integer> answers = new ArrayList();
        answers.add(ans_1);
        answers.add(ans_2);
        answers.add(ans_3);
        answers.add(ans_4);
        Collections.shuffle(answers);
        Integer a = answers.get(0);
        Integer b = answers.get(1);
        Integer c = answers.get(2);
        Integer d = answers.get(3);
        answer_dict = new HashMap<String, Integer>();
        answer_dict.put(String.valueOf('a'),a);
        answer_dict.put(String.valueOf('b'),b);
        answer_dict.put(String.valueOf('c'),c);
        answer_dict.put(String.valueOf('d'),d);
        String text = String.format("%s %s %s = ?\nA. %s\nB. %s\nC. %s\nD. %s", 
        a1, operation, a2, a, b, c, d); 
        setImage(new GreenfootImage(text, 30, Color.WHITE, new Color(50,100,0))); 
    }
    public void act()
    {
        // Add your action code here.
        String key = Greenfoot.getKey();
        timer ++;
        if (key != null){
            if (answer_dict.get(key) == this.right_ans) {
                getWorldOfType(MyWorld.class).solvedproblem();
                text = "Correct";
            }
            else {
                getWorldOfType(MyWorld.class).wrongproblem();
                text="Wrong";
            }
            if (timer % 15 == 0 && text != "") {
                text = "";
            }
            (getWorld()).showText(text, 400, 350);
            getWorld().removeObject(this);
        }
    }
}
