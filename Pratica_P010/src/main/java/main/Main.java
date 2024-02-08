package main;

import dao.CoelhoDAO;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CoelhoDAO coelho = new CoelhoDAO();
		coelho.menuCoelho();
	}

}
