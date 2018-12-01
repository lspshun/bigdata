package com.lsp.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.lang.StringUtils;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class RemoteUtil {

	private static String DEFAULTCHART = "UTF-8";
	private Connection conn;
	private String host;
	private String userName;
	private String userPwd;

	public RemoteUtil(String host, String userName, String userPwd) {
		this.host = host;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public Boolean login() {
		boolean flg = false;
		try {
			conn = new Connection(host);
			conn.connect();// 连接
			flg = conn.authenticateWithPassword(userName, userPwd);// 认证
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flg;
	}

	public String execute(String cmd) {
		String result = "";
		try {
			if (login()) {
				System.out.println("登录成功");
				Session session = conn.openSession();// 打开一个会话
				session.execCommand(cmd);// 执行命令
				result = processStdout(session.getStdout(), DEFAULTCHART);
				// 如果为得到标准输出为空，说明脚本执行出错了
				if (StringUtils.isBlank(result)) {
					result = processStdout(session.getStderr(), DEFAULTCHART);
				}
				conn.close();
				session.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String processStdout(InputStream in, String charset) {
		InputStream stdout = new StreamGobbler(in);
		StringBuffer buffer = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(stdout, charset));
			String line = null;
			while ((line = br.readLine()) != null) {
				buffer.append(line + "\n");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public static void setCharset(String charset) {
		DEFAULTCHART = charset;
	}

	public static void main(String[] args) {
		RemoteUtil remoteUtil = new RemoteUtil("192.168.116.200","bigdata","bigdata");
		String result = remoteUtil.execute("source .bash_profile && sqoop list-databases --connect jdbc:mysql://192.168.116.1/ --username root --password mysql");
		System.out.println(result);
	}

}
