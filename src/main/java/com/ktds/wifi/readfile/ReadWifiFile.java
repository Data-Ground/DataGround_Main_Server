package com.ktds.wifi.readfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ktds.wifi.vo.WifiVO;

@Component
public class ReadWifiFile {

	public List<WifiVO> getWifiList() {

		File wifiFile = new File("C:\\Users\\82104\\Desktop\\wifi");

		List<WifiVO> wifiVOList = new ArrayList<WifiVO>();


		for (File file : wifiFile.listFiles()) {

			try {
				
				Files.readAllLines(Paths.get(file.getAbsolutePath()))
						.stream()
						.skip(1)
						.map(str -> str.replaceAll(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", "ł"))
						.map(str -> str.replaceAll("\"", ""))
						.map(str -> str.split("ł", -1))
						.filter(arr -> arr.length == 15)
						.map(arr -> {

							WifiVO wifiVO = new WifiVO();
							
							if (arr[0].equals(arr[1])) {
								wifiVO.setLocation(arr[0]);
							} else {
								wifiVO.setLocation(arr[0] + " " + arr[1]);
							}
							wifiVO.setAddress(arr[8]);
							wifiVO.setLatitude(arr[12].trim());
							wifiVO.setLongitude(arr[13].trim());

							return wifiVO;
						})
						.forEach(wifiVOList::add);
			} 
			catch (IOException e) {
			}
		}
		return wifiVOList;
	}
	
	public List<WifiVO> getPakinglotList() {

		File wifiFile = new File("C:\\Users\\82104\\Desktop\\parkinglot");

		List<WifiVO> wifiVOList = new ArrayList<WifiVO>();


		for (File file : wifiFile.listFiles()) {

			try {
				
				Files.readAllLines(Paths.get(file.getAbsolutePath()))
						.stream()
						.skip(1)
						.map(str -> str.replaceAll(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", "ł"))
						.map(str -> str.replaceAll("\"", ""))
						.map(str -> str.split("ł", -1))
						.filter(arr -> arr.length == 15)
						.map(arr -> {

							WifiVO wifiVO = new WifiVO();
							
							if (arr[0].equals(arr[1])) {
								wifiVO.setLocation(arr[0]);
							} else {
								wifiVO.setLocation(arr[0] + " " + arr[1]);
							}
							wifiVO.setAddress(arr[8]);
							wifiVO.setLatitude(arr[12].trim());
							wifiVO.setLongitude(arr[13].trim());

							return wifiVO;
						})
						.forEach(wifiVOList::add);
			} 
			catch (IOException e) {
			}
		}
		return wifiVOList;
	}
}
