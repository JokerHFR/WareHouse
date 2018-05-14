package Test;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
public class test {
public static void main(String[] args) {
	List<String> a=new ArrayList<String>();
	a.add("1");
	a.add("2");
	a.add("3");
	a.add("4");
	a.add("5");
	a.remove(3);
	System.out.println(a.get(3));
} 
}