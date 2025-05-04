package workshop.animal.entity;

public interface Pet {
	String getName(); //public abstract 안 붙여도 자동임
	void setName(String name);
	public abstract void play();
}
