package com.petcenter.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/prueba")
public class Prueba {

	@RequestMapping("/")
	public String inicio(){
		return "medica/prueba";
	}
	
	@RequestMapping(value="/ajax", method=RequestMethod.POST)
	public @ResponseBody String  agregarItem (HttpServletRequest request,
								@RequestParam("txtFILE") MultipartFile txtFILE){

		String context = request.getServletContext().getContextPath();
		String real = request.getServletContext().getRealPath(""); 
		String nombre = txtFILE.getOriginalFilename();
		
		try {
			FileImageOutputStream fios = new FileImageOutputStream(new File(real+nombre));
			fios.write(txtFILE.getBytes());
			fios.flush();
			fios.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "<img alt='img' src='"+context+"/prueba/photo2?nombre="+nombre+"'>";
	}
	
//	@RequestMapping(value="/imagen")
//	public void  agregarItem (HttpServletRequest request, HttpServletResponse response,
//								@RequestParam("nombre") String nombre){
//		System.out.println(nombre);
//		response.setHeader("cacha-control", "no-cache");
//		response.setContentType("image/jpg"); 
//
//		String real = request.getServletContext().getRealPath(""); 
//		
//		try {
//			FileImageInputStream fios = new FileImageInputStream(new File(real+"/"+nombre));
//			response.
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		
//	}
	
	@ResponseBody
	@RequestMapping(value = "/photo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] testphoto(HttpServletRequest request,@RequestParam("nombre") String nombre) throws IOException {
//		String context = request.getServletContext().getContextPath();
		String real = request.getServletContext().getRealPath(""); 
//	    InputStream in = request.getServletContext().getResourceAsStream(real+nombre);
		InputStream fios = new FileInputStream(new File(real+nombre));
	    return IOUtils.toByteArray(fios);
	}
	
	@RequestMapping(value = "/photo2", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImageAsResponseEntity(HttpServletRequest request,
			@RequestParam String nombre) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    String real = request.getServletContext().getRealPath("");
	    ResponseEntity<byte[]> responseEntity = null;
		InputStream is;
		try {
			is = new FileInputStream(new File(real+nombre));
			byte[] media = IOUtils.toByteArray(is);
			headers.setContentLength(media.length);
			responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
//	    headers.setCacheControl(CacheControl);
		
	    return responseEntity;
	}
}
