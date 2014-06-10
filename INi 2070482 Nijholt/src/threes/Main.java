package threes;

import threes.controller.Controller;
import threes.view.GUI;

public class Main {

	public static void main(String[] args) {
		new Controller(new GUI("Threes"));
	}

}
