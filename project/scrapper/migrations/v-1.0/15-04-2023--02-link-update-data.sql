-- liquibase formatted sql


-- changeset Artemysis:add_update_data_column_to_link_table
ALTER TABLE link
    ADD COLUMN update_data JSONB DEFAULT '{}'::jsonb NOT NULL;