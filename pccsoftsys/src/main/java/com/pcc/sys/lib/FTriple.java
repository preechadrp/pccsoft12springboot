package com.pcc.sys.lib;

public class FTriple<A, B, C> {

	private A first;
	private B second;
	private C third;

	public FTriple(A first, B second, C third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public A getFirst() {
		return first;
	}

	public void setFirst(A first) {
		this.first = first;
	}

	public B getSecond() {
		return second;
	}

	public void setSecond(B second) {
		this.second = second;
	}

	public C getThird() {
		return third;
	}

	public void setThird(C third) {
		this.third = third;
	}

}
