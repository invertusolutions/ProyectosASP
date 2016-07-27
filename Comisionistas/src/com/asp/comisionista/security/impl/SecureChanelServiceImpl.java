package com.asp.comisionista.security.impl;

import java.io.File;
import java.util.ResourceBundle;

import com.asp.comisionista.security.SecureChanelService;
import com.asp.comisionista.utils.ConstantesUtil;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SecureChanelServiceImpl  implements SecureChanelService{

	public SecureChanelServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public boolean sendFile(String nombreArchivo){
		boolean isSuccessful = false;
		JSch jSch = new JSch();
		ResourceBundle resource = ConstantesUtil.RESOURCE_CONEXION_REMOTA;

        if (resource != null) {
            String usuario = resource.getString("usuario");
            String contrasena = resource.getString("contrasena");
            String servidor = resource.getString("servidor");
            String puerto = resource.getString("puerto");
            String hosts = resource.getString("hosts");
            String rutaRemota = resource.getString("directorioRemoto");
            String rutaLocal = ConstantesUtil.RUTA_ARCHIVO;


            Channel channel = null;
            Session session = null;
            try {

				jSch.addIdentity(contrasena);
				jSch.setKnownHosts(hosts);
				
                session = jSch.getSession(usuario, servidor, Integer.valueOf(puerto));
                session.setConfig("StrictHostKeyChecking", "no");
                session.connect();

                channel = session.openChannel("sftp");
                channel.connect();
                ChannelSftp sftp = (ChannelSftp) channel;
                int mode = ChannelSftp.OVERWRITE;

                sftp.put(rutaLocal + File.separator + nombreArchivo, rutaRemota + File.separator + nombreArchivo, mode);

                isSuccessful = true;
            } catch (JSchException e) {
            	isSuccessful = false;
                System.out.println(e);
            } catch (SftpException e) {
            	isSuccessful = false;
            	System.out.println(e);
            } finally {
                if (channel != null) {
                    channel.disconnect();
                }

                if (session != null) {
                    session.disconnect();
                }
            }
            
            
        }
        return isSuccessful;
    }
}
