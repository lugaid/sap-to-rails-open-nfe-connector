package br.com.lugaid;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton class to load conf\config.properties configurations.
 */
public class SapConnectorConfig {
	private static final String CONFIG_FILE = "conf\\config.properties";

	private static Logger logger = LoggerFactory
			.getLogger(SapConnectorConfig.class);
	private static SapConnectorConfig sapConnectorConfig;

	private String jcoConfigName;
	private TimeZone timeZone;
	private int jcoTraceLevel;

	private SapConnectorConfig(String jcoConfigName, String timeZone,
			int jcoTraceLevel) {
		setJcoConfigName(jcoConfigName);
		setTimeZone(TimeZone.getTimeZone(timeZone));
		setJcoTraceLevel(jcoTraceLevel);
	}

	/**
	 * Return the name of the JCo config files.
	 * @return name of the JCo config files as String
	 */
	public String getJcoConfigName() {
		return jcoConfigName;
	}

	/**
	 * Set the name of the JCo config files.
	 * @param jcoConfigName Name of the JCo config files
	 */
	public void setJcoConfigName(String jcoConfigName) {
		if (jcoConfigName == null || jcoConfigName.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"jcoConfigName config property is obligatory and cannot be blank, check config.properties file.");
		}

		this.jcoConfigName = jcoConfigName;
	}

	/**
	 * Returns the time zone to be used into SAP timestamp conversion
	 * @return time zone as TimeZone
	 */
	public TimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * Set the time zone to be used into SAP timestamp conversion
	 * @param timeZone Time zone to be used into SAP timestamp conversion
	 */
	public void setTimeZone(TimeZone timeZone) {
		if (timeZone == null) {
			throw new IllegalArgumentException(
					"timeZone config property is obligatory and must be a valid ID for TimeZone class");
		}

		this.timeZone = timeZone;
	}

	/**
	 * Returns the trace level for JCo.
	 * @return trace level as int.
	 */
	public int getJcoTraceLevel() {
		return jcoTraceLevel;
	}

	/**
	 * Set the trace level for JCo.
	 * @param jcoTraceLevel Trace level.
	 */
	public void setJcoTraceLevel(int jcoTraceLevel) {
		if (jcoTraceLevel < 0 || jcoTraceLevel > 10) {
			throw new IllegalArgumentException(
					"jcoTraceLevel config property must be between 0 and 10.");
		}

		this.jcoTraceLevel = jcoTraceLevel;
	}

	/**
	 * Get singleton instance of SapConnectorConfig
	 * @return Singleton instance as SapConnectorConfig
	 */
	public static SapConnectorConfig getInstance() {
		if (sapConnectorConfig == null) {
			sapConnectorConfig = loadConfigFile();
			return sapConnectorConfig;
		} else {
			return sapConnectorConfig;
		}
	}

	/**
	 * Load config file and define a new instance of SapConnectorConfig
	 * @return New instance of SapConnectorConfig.
	 */
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
