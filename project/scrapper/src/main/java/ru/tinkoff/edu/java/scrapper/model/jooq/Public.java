/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.model.jooq;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import ru.tinkoff.edu.java.scrapper.model.jooq.tables.Chat;
import ru.tinkoff.edu.java.scrapper.model.jooq.tables.ChatLink;
import ru.tinkoff.edu.java.scrapper.model.jooq.tables.Databasechangelog;
import ru.tinkoff.edu.java.scrapper.model.jooq.tables.Databasechangeloglock;
import ru.tinkoff.edu.java.scrapper.model.jooq.tables.Link;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.chat</code>.
     */
    public final Chat CHAT = Chat.CHAT;

    /**
     * The table <code>public.chat_link</code>.
     */
    public final ChatLink CHAT_LINK = ChatLink.CHAT_LINK;

    /**
     * The table <code>public.databasechangelog</code>.
     */
    public final Databasechangelog DATABASECHANGELOG = Databasechangelog.DATABASECHANGELOG;

    /**
     * The table <code>public.databasechangeloglock</code>.
     */
    public final Databasechangeloglock DATABASECHANGELOGLOCK = Databasechangeloglock.DATABASECHANGELOGLOCK;

    /**
     * The table <code>public.link</code>.
     */
    public final Link LINK = Link.LINK;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    @NotNull
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    @NotNull
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Chat.CHAT,
            ChatLink.CHAT_LINK,
            Databasechangelog.DATABASECHANGELOG,
            Databasechangeloglock.DATABASECHANGELOGLOCK,
            Link.LINK
        );
    }
}