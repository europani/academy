package ch07;

public class Exercise7_17 {

}
class Marine1 extends Unit1 { 
	int x, y; 	
	void move(int x, int y) {} 
	void stop() {} 
	void stimPack() {} 
}

class Tank1 extends Unit1 {
	int x, y;
	void move(int x, int y) {}
	void stop() {}
	void changeMode() {}
}

class Dropship1 extends Unit1 {
	int x, y;
	void move(int x, int y) {}
	void stop() {}
	void load() {}
	void unload() {}
}

abstract class Unit1 {
	int x, y;
	abstract void move(int x, int y);
	abstract void stop(); 
}
