/**
 * Copyright (c) 2018, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.vindell.dbperms.jdbc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.management.StandardMBean;

public class PermsOptions extends StandardMBean implements PermsOptionsMBean {

	public static final String DRIVERLIST = "driverlist";
	public static final String JNDICONTEXTFACTORY = "jndicontextfactory";
	public static final String JNDICONTEXTPROVIDERURL = "jndicontextproviderurl";
	public static final String JNDICONTEXTCUSTOM = "jndicontextcustom";
	public static final String REALDATASOURCE = "realdatasource";
	public static final String REALDATASOURCECLASS = "realdatasourceclass";
	public static final String REALDATASOURCEPROPERTIES = "realdatasourceproperties";
	public static final String CUSTOM_LOG_MESSAGE_FORMAT = "customLogMessageFormat";
	public static final String JMX = "jmx";
	public static final String JMX_PREFIX = "jmxPrefix";

	// those set indirectly (via properties visible from outside)
	public static final String DRIVER_NAMES = "driverNames";
	public static final String MODULE_FACTORIES = "moduleFactories";
	public static final String MODULE_NAMES = "moduleNames";
	public static final String LOG_MESSAGE_FORMAT_INSTANCE = "logMessageFormatInstance";
	public static final String APPENDER_INSTANCE = "appenderInstance";

	public static final Map<String, String> defaults;

	static {
		defaults = new HashMap<String, String>();
		defaults.put(JMX, Boolean.TRUE.toString());
	}

	private final P6OptionsRepository optionsRepository;

	public PermsOptions(final P6OptionsRepository optionsRepository) {
		super(P6SpyOptionsMBean.class, false);
		this.optionsRepository = optionsRepository;
	}

	/**
	 * Utility method, to make accessing options from app less verbose.
	 * 
	 * @return active instance of the {@link P6SpyLoadableOptions}
	 */
	public static P6SpyLoadableOptions getActiveInstance() {
		return P6ModuleManager.getInstance().getOptions(PermsOptions.class);
	}

	// JMX exporsed API

	@Override
	public String getDriverlist() {
		return optionsRepository.get(String.class, DRIVERLIST);
	}

	@Override
	public void setDriverlist(final String driverlist) {
		optionsRepository.setSet(String.class, DRIVER_NAMES, driverlist);
		// setting effective string
		optionsRepository.set(String.class, DRIVERLIST,
				P6Util.joinNullSafe(optionsRepository.getSet(String.class, DRIVER_NAMES), ","));
	}

	@Override
	public boolean getReloadProperties() {
		return optionsRepository.get(Boolean.class, RELOADPROPERTIES);
	}

	@Override
	public void setReloadProperties(String reloadproperties) {
		optionsRepository.set(Boolean.class, RELOADPROPERTIES, reloadproperties);
	}

	@Override
	public void setReloadProperties(boolean reloadproperties) {
		optionsRepository.set(Boolean.class, RELOADPROPERTIES, reloadproperties);
	}

	@Override
	public long getReloadPropertiesInterval() {
		return optionsRepository.get(Long.class, RELOADPROPERTIESINTERVAL);
	}

	@Override
	public void setReloadPropertiesInterval(String reloadpropertiesinterval) {
		optionsRepository.set(Long.class, RELOADPROPERTIESINTERVAL, reloadpropertiesinterval);
	}

	@Override
	public void setReloadPropertiesInterval(long reloadpropertiesinterval) {
		optionsRepository.set(Long.class, RELOADPROPERTIESINTERVAL, reloadpropertiesinterval);
	}

	@Override
	public void setJNDIContextFactory(String jndicontextfactory) {
		optionsRepository.set(String.class, JNDICONTEXTFACTORY, jndicontextfactory);
	}

	@Override
	public void unSetJNDIContextFactory() {
		optionsRepository.setOrUnSet(String.class, JNDICONTEXTFACTORY, null, defaults.get(JNDICONTEXTFACTORY));
	}

	@Override
	public String getJNDIContextFactory() {
		return optionsRepository.get(String.class, JNDICONTEXTFACTORY);
	}

	@Override
	public void unSetJNDIContextProviderURL() {
		optionsRepository.setOrUnSet(String.class, JNDICONTEXTPROVIDERURL, null, defaults.get(JNDICONTEXTPROVIDERURL));
	}

	@Override
	public void setJNDIContextProviderURL(String jndicontextproviderurl) {
		optionsRepository.set(String.class, JNDICONTEXTPROVIDERURL, jndicontextproviderurl);
	}

	@Override
	public String getJNDIContextProviderURL() {
		return optionsRepository.get(String.class, JNDICONTEXTPROVIDERURL);
	}

	@Override
	public void setJNDIContextCustom(String jndicontextcustom) {
		optionsRepository.set(String.class, JNDICONTEXTCUSTOM, jndicontextcustom);
	}

	@Override
	public void unSetJNDIContextCustom() {
		optionsRepository.setOrUnSet(String.class, JNDICONTEXTCUSTOM, null, defaults.get(JNDICONTEXTCUSTOM));
	}

	@Override
	public String getJNDIContextCustom() {
		return optionsRepository.get(String.class, JNDICONTEXTCUSTOM);
	}

	@Override
	public void setRealDataSource(String realdatasource) {
		optionsRepository.set(String.class, REALDATASOURCE, realdatasource);
	}

	@Override
	public void unSetRealDataSource() {
		optionsRepository.setOrUnSet(String.class, REALDATASOURCE, null, defaults.get(REALDATASOURCE));
	}

	@Override
	public String getRealDataSource() {
		return optionsRepository.get(String.class, REALDATASOURCE);
	}

	@Override
	public void setRealDataSourceClass(String realdatasourceclass) {
		optionsRepository.set(String.class, REALDATASOURCECLASS, realdatasourceclass);
	}

	@Override
	public void unSetRealDataSourceClass() {
		optionsRepository.setOrUnSet(String.class, REALDATASOURCECLASS, null, defaults.get(REALDATASOURCECLASS));
	}

	@Override
	public String getRealDataSourceClass() {
		return optionsRepository.get(String.class, REALDATASOURCECLASS);
	}

	@Override
	public void setRealDataSourceProperties(String realdatasourceproperties) {
		optionsRepository.set(String.class, REALDATASOURCEPROPERTIES, realdatasourceproperties);
	}

	@Override
	public void unSetRealDataSourceProperties() {
		optionsRepository.setOrUnSet(String.class, REALDATASOURCEPROPERTIES, null,
				defaults.get(REALDATASOURCEPROPERTIES));
	}

	@Override
	public String getRealDataSourceProperties() {
		return optionsRepository.get(String.class, REALDATASOURCEPROPERTIES);
	}

	@Override
	public Set<String> getDriverNames() {
		return optionsRepository.getSet(String.class, DRIVER_NAMES);
	}

	/**
	 * Returns the databaseDialectDateFormat.
	 *
	 * @return String
	 */
	@Override
	public String getDatabaseDialectDateFormat() {
		return optionsRepository.get(String.class, DATABASE_DIALECT_DATE_FORMAT);
	}

	/**
	 * Sets the databaseDialectDateFormat.
	 *
	 * @param databaseDialectDateFormat
	 *            The databaseDialectDateFormat to set
	 */
	@Override
	public void setDatabaseDialectDateFormat(String databaseDialectDateFormat) {
		optionsRepository.set(String.class, DATABASE_DIALECT_DATE_FORMAT, databaseDialectDateFormat);
	}

	/**
	 * Returns the databaseDialectBooleanFormat.
	 *
	 * @return String
	 */
	@Override
	public String getDatabaseDialectBooleanFormat() {
		return optionsRepository.get(String.class, DATABASE_DIALECT_BOOLEAN_FORMAT);
	}

	/**
	 * Sets the databaseDialectDateFormat.
	 *
	 * @param databaseDialectBooleanFormat
	 *            The databaseDialectBooleanFormat to set
	 */
	@Override
	public void setDatabaseDialectBooleanFormat(String databaseDialectBooleanFormat) {
		optionsRepository.set(String.class, DATABASE_DIALECT_BOOLEAN_FORMAT, databaseDialectBooleanFormat);
	}

	/**
	 * Returns the customLogMessageFormat.
	 *
	 * @return String
	 */
	@Override
	public String getCustomLogMessageFormat() {
		return optionsRepository.get(String.class, CUSTOM_LOG_MESSAGE_FORMAT);
	}

	/**
	 * Sets the customLogMessageFormat.
	 *
	 * @param customLogMessageFormat
	 *            The CustomLogMessageFormat to set
	 */
	@Override
	public void setCustomLogMessageFormat(String customLogMessageFormat) {
		optionsRepository.set(String.class, CUSTOM_LOG_MESSAGE_FORMAT, customLogMessageFormat);
	}

	@Override
	public String getModulelist() {
		// TODO handle getters for lists represented in csv strings correctly
		return optionsRepository.get(String.class, MODULELIST);
	}

	@Override
	public void setModulelist(String modulelist) {
		optionsRepository.setSet(String.class, MODULE_NAMES, modulelist);
		// setting effective string
		optionsRepository.set(String.class, MODULELIST,
				P6Util.joinNullSafe(optionsRepository.getSet(String.class, MODULE_NAMES), ","));
		optionsRepository.setSet(P6Factory.class, MODULE_FACTORIES, modulelist);
	}

	@Override
	public Set<String> getModuleNames() {
		return optionsRepository.getSet(String.class, MODULE_NAMES);
	}

	@Override
	public void setAppend(boolean append) {
		optionsRepository.set(Boolean.class, APPEND, append);
	}

	@Override
	public boolean getAppend() {
		return optionsRepository.get(Boolean.class, APPEND);
	}

	@Override
	public String getAppender() {
		return optionsRepository.get(String.class, APPENDER);
	}

	@Override
	public P6Logger getAppenderInstance() {
		return optionsRepository.get(P6Logger.class, APPENDER_INSTANCE);
	}

	@Override
	public void setAppender(String className) {
		optionsRepository.set(String.class, APPENDER, className);
		optionsRepository.set(P6Logger.class, APPENDER_INSTANCE, className);
	}

	@Override
	public void setDateformat(String dateformat) {
		optionsRepository.set(String.class, DATEFORMAT, dateformat);
	}

	@Override
	public String getDateformat() {
		return optionsRepository.get(String.class, DATEFORMAT);
	}

	@Override
	public boolean getStackTrace() {
		return optionsRepository.get(Boolean.class, STACKTRACE);
	}

	@Override
	public void setStackTrace(boolean stacktrace) {
		optionsRepository.set(Boolean.class, STACKTRACE, stacktrace);
	}

	@Override
	public void setStackTrace(String stacktrace) {
		optionsRepository.set(Boolean.class, STACKTRACE, stacktrace);
	}

	@Override
	public String getStackTraceClass() {
		return optionsRepository.get(String.class, STACKTRACECLASS);
	}

	@Override
	public void setStackTraceClass(String stacktraceclass) {
		optionsRepository.set(String.class, STACKTRACECLASS, stacktraceclass);
	}

	@Override
	public void setLogfile(String logfile) {
		optionsRepository.set(String.class, LOGFILE, logfile);
	}

	@Override
	public String getLogfile() {
		return optionsRepository.get(String.class, LOGFILE);
	}

	@Override
	public void setAppend(String append) {
		optionsRepository.set(Boolean.class, APPEND, append);
	}

	@Override
	public String getLogMessageFormat() {
		return optionsRepository.get(String.class, LOG_MESSAGE_FORMAT);
	}

	@Override
	public void setLogMessageFormat(final String logMessageFormat) {
		optionsRepository.set(String.class, LOG_MESSAGE_FORMAT, logMessageFormat);
		optionsRepository.set(MessageFormattingStrategy.class, LOG_MESSAGE_FORMAT_INSTANCE, logMessageFormat);
	}

	@Override
	public MessageFormattingStrategy getLogMessageFormatInstance() {
		return optionsRepository.get(MessageFormattingStrategy.class, LOG_MESSAGE_FORMAT_INSTANCE);
	}

	@Override
	public Map<String, String> getDefaults() {
		return defaults;
	}

	@Override
	public boolean getJmx() {
		return optionsRepository.get(Boolean.class, JMX);
	}

	@Override
	public void setJmx(String string) {
		optionsRepository.set(Boolean.class, JMX, string);
	}

	@Override
	public void setJmx(boolean string) {
		optionsRepository.set(Boolean.class, JMX, string);
	}

	@Override
	public String getJmxPrefix() {
		return optionsRepository.get(String.class, JMX_PREFIX);
	}

	@Override
	public void setJmxPrefix(String jmxPrefix) {
		optionsRepository.set(String.class, JMX_PREFIX, jmxPrefix);
	}

}
