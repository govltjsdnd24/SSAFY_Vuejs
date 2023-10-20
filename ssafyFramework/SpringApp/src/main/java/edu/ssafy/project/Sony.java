package edu.ssafy.project;

import org.springframework.stereotype.Component;

@Component(value = "sony")
public class Sony implements Camera {

	@Override
	public void takePicture() {
		System.out.println("소니 카메라가 사진을 찍습니다.");

	}

}
