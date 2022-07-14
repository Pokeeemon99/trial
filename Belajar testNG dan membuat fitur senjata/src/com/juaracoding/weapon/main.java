package com.juaracoding.weapon;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Weapon m4 = new Weapon(50);
		 m4.checkAmmo();
		 m4.shoot(40);
		 m4.checkAmmo();
		 m4.reload();
		 m4.checkAmmo();

	}

}
