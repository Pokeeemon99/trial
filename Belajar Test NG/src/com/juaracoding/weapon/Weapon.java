package com.juaracoding.weapon;

public class Weapon {
	static int ammo;
	final int shoot=-1;
	final int reload=30;
	
	
	Weapon(int ammo){
		if(ammo>30) {
			ammo=30; Weapon.ammo = ammo; //Batasan maksimal isi peluru awal biar ga ada cheater
		}
	}
	
	int shoot(int totalShoot){
		if (ammo>0) {
			ammo+=shoot*totalShoot;
			if(ammo<0) {
				ammo=0;
				System.out.println("butuh reload");
			}
		}
		return ammo;
	}
	
	int reload(){
		ammo+=reload;
			if(ammo>30) {
				ammo=30;	//asumsi nilai maksimal peluru 30
			}
		System.out.println("peluru reload");
		return ammo;
	}
	
	int checkAmmo() {
		System.out.println("sisa peluru " + ammo);
		return ammo;
	}

}

