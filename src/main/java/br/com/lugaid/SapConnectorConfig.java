package br.com.lugaid;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SapConnectorConfig {
	private static final String CONFIG_FILE = "conf\\config.properties";
	private static final String TIME_ZONE_PAT = "^(\\+|\\-)(\\d{2}):(\\d{2})$";

	private static Logger logger = LoggerFactory
			.getLogger(SapConnectorConfig.class);
	private static SapConnectorConfig sapConnectorConfig;

	private String jcoConfigName;
	private String timeZone;
	private int jcoTraceLevel;

	protected SapConnectorConfig(String jcoConfigName, String timeZone,
			int jcoTraceLevel) {
		super();
		setJcoConfigName(jcoConfigName);
		setTimeZone(timeZone);
		setJcoTraceLevel(jcoTraceLevel);
	}

	public String getJcoConfigName() {
		return jcoConfigName;
	}

	public void setJcoConfigName(String jcoConfigName) {
		if (jcoConfigName == null || jcoConfigName.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"jcoConfigName config property is obligatory and cannot be blank, check config.properties file.");
		}

		this.jcoConfigName = jcoConfigName;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		if (timeZone == null || !timeZone.matches(TIME_ZONE_PAT)) {
			throw new IllegalArgumentException(
					"timeZone config property is obligatory and must matches pattern "
							.concat(TIME_ZONE_PAT));
		}

		this.timeZone = timeZone;
	}

	public int getJcoTraceLevel() {
		return jcoTraceLevel;
	}

	public void setJcoTraceLevel(int jcoTraceLevel) {
		if (jcoTraceLevel < 0 || jcoTraceLevel > 10) {
			throw new IllegalArgumentException(
					"jcoTraceLevel config property must be between 0 and 10.");
		}

		this.jcoTraceLevel = jcoTraceLevel;
	}

	public static SapConnectorConfig getInstance() {
		if (sapConnectorConfig == null) {
			return loadConfigFile();
		} else {
			return sapConnectorConfig;
		}
	}

	private static SapConnectorConfig loadConfigFile() {
		Properties properties = new Properties();
		try {
			logger.info("Loading {} file.", CONFIG_FILE);

			properties.load(new FileInputStream(CONFIG_FILE));
			String jcoConfigName = properties.getProperty("jcoConfigName");
			String timeZone = properties.getProperty("timeZone");
			int jcoTraceLevel = Integer.parseInt(properties
					.getProperty("jcoTraceLevel"));

			logger.info("{} successfully loaded.", CONFIG_FILE);

			SapConnectorConfig sapConnectorConfig = new SapConnectorConfig(
					jcoConfigName, timeZone, jcoTraceLevel);

			logger.info("Configs loaded {}.", sapConnectorConfig.toString());

			return sapConnectorConfig;
		} catch (IOException e) {
			logger.error("Error reading app config file {}.", e.getMessage());
			logger.debug("Stack trace ", e);
			throw new IllegalStateException(
					CONFIG_FILE.concat(" could not be loaded exiting system."),
					e);
		}
	}

	@Override
	public String toString() {
		return "SapConnectorConfig [jcoConfigName=" + jcoConfigName
				+ ", timeZone=" + timeZone + ", jcoTraceLevel=" + jcoTraceLevel
				+ "]";
	}
}
