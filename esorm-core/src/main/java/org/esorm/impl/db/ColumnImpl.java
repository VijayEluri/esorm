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
package org.esorm.impl.db;

import org.esorm.RegisteredExceptionWrapper;
import org.esorm.entity.db.Column;
import org.esorm.entity.db.FromExpression;
import org.esorm.entity.db.FromExpressionQueryData;
import org.esorm.entity.db.Table;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @author Vitalii Tymchyshyn
 */
public class ColumnImpl
        implements Column {
    private Table table;
    private boolean insertable = true, updateable = true, queryable = true;
    private Iterable<FromExpression> tables;
    private String name;

    /**
     * @param table
     * @param name
     */
    public ColumnImpl(Table table, String name) {
        setTable(table);
        setName(name);
    }

    /* (non-Javadoc)
     * @see org.esorm.entity.db.ValueExpression#getTables()
     */
    public Iterable<FromExpression> getTables() {
        return tables;
    }

    /* (non-Javadoc)
     * @see org.esorm.entity.db.ValueExpression#appendQuery(java.lang.Appendable, java.util.Map)
     */
    public void appendQuery(Appendable appendTo,
                            Map<? extends FromExpression, ? extends FromExpressionQueryData> tableNames) {
        try
        {
            appendTo.append(tableNames.get(table).getAlias()).append(".").append(name);
        } catch (IOException e)
        {
            throw new RegisteredExceptionWrapper(e);
        }

    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
        this.tables = Collections.<FromExpression>singleton(table);
    }

    public boolean isInsertable() {
        return insertable;
    }

    public void setInsertable(boolean insertable) {
        this.insertable = insertable;
    }

    public boolean isUpdateable() {
        return updateable;
    }

    public void setUpdateable(boolean updateable) {
        this.updateable = updateable;
    }

    public boolean isQueryable() {
        return queryable;
    }

    public void setQueryable(boolean queryable) {
        this.queryable = queryable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
