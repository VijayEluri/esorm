/**
 * 
 * Copyright 2010 Vitalii Tymchyshyn
 * This file is part of EsORM.
 *
 * EsORM is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EsORM is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with EsORM.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.esorm.impl;

import java.util.Collections;
import java.util.List;

import org.esorm.*;

/**
 * @author Vitalii Tymchyshyn
 *
 */
public class DefaultQueryConf
implements QueryRunner
{
    public static final DefaultQueryConf INSTANCE = new DefaultQueryConf();
    
    private DefaultQueryConf() {
        
    }

    public ErrorHandler getErrorHandler()
    {
        return ErrorHandlerImpl.INSTANCE;
    }

    public ConnectionProvider getConnectionProvider()
    {
        throw new UnsupportedOperationException("There is no default ConnectionProvider. Please supply one with setConnectionProvider method");
    }

    /* (non-Javadoc)
     * @see org.esorm.QueryRunner#getDataAccessor()
     */
    public DataAccessor getDataAccessor()
    {
        return DataAccessorImpl.INSTANCE;
    }

    /* (non-Javadoc)
     * @see org.esorm.QueryRunner#getConfigurationImports()
     */
    public List<String> getEntityConfigurationLocations()
    {
        return Collections.emptyList();
    }

    /* (non-Javadoc)
     * @see org.esorm.QueryRunner#getConfigurationImportsIterable()
     */
    public Iterable<String> getEntityConfigurationLocationsIterable()
    {
        return Collections.emptyList();
    }

    /* (non-Javadoc)
     * @see org.esorm.QueryRunner#getEntityBeanImports()
     */
    public List<String> getEntityImplementationLocations()
    {
        return Collections.emptyList();
    }

    /* (non-Javadoc)
     * @see org.esorm.QueryRunner#getEntityBeanIterable()
     */
    public Iterable<String> getEntityImplementationLocationsIterable()
    {
        return Collections.emptyList();
    }

    /* (non-Javadoc)
     * @see org.esorm.QueryRunner#getMutableEntityConfiguration(java.lang.String)
     */
    public MutableEntityConfiguration getMutableEntityConfiguration(String name)
    {
        return null;
    }

    /* (non-Javadoc)
     * @see org.esorm.QueryRunner#getEntitiesConfiguratorsIterable()
     */
    public Iterable<EntitiesConfigurator> getEntitiesConfiguratorsIterable()
    {
        // TODO Add autoloading configurators
        return Collections.emptyList();
    }

    /* (non-Javadoc)
     * @see org.esorm.QueryRunner#getEntitiesManagersIterable()
     */
    public Iterable<EntitiesManager> getEntitiesManagersIterable()
    {
        // TODO Add autoloading managers
        return Collections.emptyList();
    }

}
