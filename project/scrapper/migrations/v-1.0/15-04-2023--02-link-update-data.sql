ALTER TABLE link
    ADD COLUMN update_data JSONB DEFAULT '{}'::jsonb NOT NULL;