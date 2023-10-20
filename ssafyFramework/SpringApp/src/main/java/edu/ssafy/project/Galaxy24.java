package edu.ssafy.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "samsung")

public class Galaxy24 implements Phone {
	private Camera camera;
	
	public Galaxy24() {}
	
	
	public Galaxy24(@Autowired @Qualifier(value = "sony") Camera camera) {
		this.camera = camera;
	}
	public void setCamera(Camera camera) {
		this.camera=camera;
	}

	@Override
	public void call() {
		System.out.println("삼성폰이 전화를 함");
	}

	@Override
	public void powerOn() {
		System.out.println("삼성폰이 전원을 킴");

	}

	@Override
	public void powerOff() {
		System.out.println("삼성폰이 전원을 끔");

	}

	@Override
	public void takePicture() {
		//System.out.println("삼성폰이 사진");
		camera.takePicture();
	}

}
