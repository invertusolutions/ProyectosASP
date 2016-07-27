package com.asp.comisionista.jsf.bean;

import java.io.File;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FilenameUtils;

import com.asp.comisionista.security.SecureChanelService;
import com.asp.comisionista.security.impl.SecureChanelServiceImpl;
import com.asp.comisionista.utils.ActivityLogEJB;
import com.asp.comisionista.utils.ConstantesUtil;


/**
 * @Author Kamal Wickramanayake
 */

@ManagedBean(name = "uploadFormController")
@RequestScoped
public class UploadController {
	// The upload directory 
	private String uploadPath = ConstantesUtil.RUTA_ARCHIVO;
	
	// Uploaded files will be saved with a file name containing the following prefix
	// and suffix.
	private String uploadFilePrefix = "";
	private String uploadFileSuffix = "";
	
	
	
	// Set to true if upload is successful
	private boolean uploadSuccessful = false;
	// After processing form submission, set this to true to reset the form.
	private boolean resetForm = false;
	// Holds a message that will be displayed in the browser after form submission
	// is processed.
	private String statusMessage = "";
	private String finalMessage = "";
	
	// A field to hold the value of a typical form element.
	private String aFormElement = "1";

	
	
	// Upload button triggers this method
	public String upload() {

		HttpServletRequest httpRequest = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();

		// Access the uploaded file from the HTTPServletRequest
		Object fileObject = httpRequest.getAttribute("uploadFile");
		finalMessage = "";
		if (fileObject == null) {
			// No file uploaded.
			statusMessage = "No se ha podido cargar el archivo";
			resetForm = false;
			uploadSuccessful = false;
			
		} else if (fileObject instanceof FileUploadException) {
			// File upload failed.
			FileUploadException fileUploadException = (FileUploadException) fileObject;
			statusMessage = "Hubo un error durante la carga: " + fileUploadException.getMessage();
			resetForm = false;
			uploadSuccessful = false;
		} else {
			FileItem fileItem = (FileItem) fileObject;

			try {
				File uploadDir = new File(uploadPath);
				uploadDir.mkdir();

				// If the saved file name should be based on upload file name, use fileName as accessed below to
				// set the uploadFilePrefix
				String fileName = FilenameUtils.getName(fileItem.getName());
				
				// Create a unique file name
				File file = File.createTempFile(fileName, uploadFileSuffix, uploadDir);
				
				uploadFilePrefix = file.getName();
				System.out.println(uploadFilePrefix);
				// Write the file
				fileItem.write(file);
				
				statusMessage = "El archivo " + fileName + " está listo para enviarse";
				resetForm = true;
				uploadSuccessful = true;
			} catch (Exception e) {
				statusMessage = "Hubo un error durante la carga: " + e.getMessage();
				resetForm = false;
				uploadSuccessful = false;
			}

		}

		// We want this specific html page containing JavaScript code to go
		// to the target iframe
		
		ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.cveENVA , "archivo", "archivo", uploadSuccessful ? 1 : 0, statusMessage);

		return "uploadFile_response";
	}
	
	public String sendFile(){
		SecureChanelService chanelService = new SecureChanelServiceImpl();
		System.out.println(uploadFilePrefix);
		if (!uploadSuccessful){
			finalMessage = "El archivo debe cargarse primero";
		} else if(chanelService.sendFile(uploadFilePrefix)){
			finalMessage = "El archivo fue enviado exitosamente";
			statusMessage = "";
		} else {
			finalMessage = "No fue posible enviar el archivo, contacte a su administrador";
		}
		
		return "uploadFile_response";
	}
	public String getStatusMessage() {
		return statusMessage;
	}

	public boolean isUploadSuccessful() {
		return uploadSuccessful;
	}

	public boolean isResetForm() {
		return resetForm;
	}


	
	public String getaFormElement() {
		return aFormElement;
	}

	public void setaFormElement(String aFormElement) {
		this.aFormElement = aFormElement;
	}

	/**
	 * @return the finalMessage
	 */
	public String getFinalMessage() {
		return finalMessage;
	}

	/**
	 * @param finalMessage the finalMessage to set
	 */
	public void setFinalMessage(String finalMessage) {
		this.finalMessage = finalMessage;
	}

	/**
	 * @return the uploadFilePrefix
	 */
	public String getUploadFilePrefix() {
		return uploadFilePrefix;
	}

	/**
	 * @param uploadFilePrefix the uploadFilePrefix to set
	 */
	public void setUploadFilePrefix(String uploadFilePrefix) {
		this.uploadFilePrefix = uploadFilePrefix;
	}

	/**
	 * @param uploadSuccessful the uploadSuccessful to set
	 */
	public void setUploadSuccessful(boolean uploadSuccessful) {
		this.uploadSuccessful = uploadSuccessful;
	}

	
}
