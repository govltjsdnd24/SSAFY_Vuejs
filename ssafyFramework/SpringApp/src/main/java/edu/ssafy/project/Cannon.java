package edu.ssafy.project;

import org.springframework.stereotype.Component;

@Component( value = "cannon")
public class Cannon implements Camera {

	@Override
	public void takePicture() {
		System.out.println("캐논이 사진을 찍습니다");

	}

}
