/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jkiss.dbeaver.model.sql.analyzer;

import org.jkiss.code.NotNull;
import org.jkiss.dbeaver.model.sql.parser.tokens.SQLTokenType;
import org.jkiss.dbeaver.model.text.parser.TPToken;

import java.util.Map;

/**
 * Interface designed in order to provide reference implementation of analyzing
 * SQL expressions
 */
public interface TableReferencesAnalyzer {
    /**
     * The method return table references filtered by condition
     */
    @NotNull
    Map<String, String> getFilteredTableReferences(@NotNull String tableAlias, boolean allowPartialMatch);

    /**
     * The method returns map of table by alias base on query expression
     */
    @NotNull
    Map<String, String> getTableAlicesFromQuery(@NotNull String query);

    /**
     * Checks if token is the name part token
     */
    public static boolean isNamePartToken(TPToken tok) {
        return tok.getData() == SQLTokenType.T_QUOTED
            || tok.getData() == SQLTokenType.T_KEYWORD
            || tok.getData() == SQLTokenType.T_OTHER;
    }
}