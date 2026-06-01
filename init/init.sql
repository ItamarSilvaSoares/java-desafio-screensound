SELECT 'CREATE DATABASE screensound_db'
    WHERE NOT EXISTS (
    SELECT FROM pg_database WHERE datname = 'screensound_db '
)\gexec