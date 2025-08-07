SET foreign_key_checks = 0;

DROP TABLE IF EXISTS personalreview;
DROP TABLE IF EXISTS fragrance_accord;
DROP TABLE IF EXISTS scentinformation_topnote;
DROP TABLE IF EXISTS scentinformation_middlenote;
DROP TABLE IF EXISTS scentinformation_basenote;
DROP TABLE IF EXISTS fragrance;
DROP TABLE IF EXISTS accord;
DROP TABLE IF EXISTS note;
DROP TABLE IF EXISTS scentinformation;
DROP TABLE IF EXISTS brand;

SET foreign_key_checks = 1;

CREATE TABLE brand (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) UNIQUE NOT NULL,
    country VARCHAR(100),
    website VARCHAR(255),
    year_founded INT,
    is_niche BOOLEAN,
    description TEXT,
    logo_url VARCHAR(255)
);

CREATE TABLE note (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE accord (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE scentinformation (
    id INT PRIMARY KEY AUTO_INCREMENT,
    season VARCHAR(100),
    time_of_day VARCHAR(100),
    longevity VARCHAR(100),
    sillage VARCHAR(100)
);

CREATE TABLE fragrance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    brand_id INT,
    perfumer VARCHAR(100),
    concentration VARCHAR(50),
    release_date DATE,
    is_refillable BOOLEAN,
    niche_vs_designer VARCHAR(50),
    description TEXT,
    pictures TEXT,
    scentinformation_id INT,
    FOREIGN KEY (brand_id) REFERENCES brand(id) ON DELETE SET NULL,
    FOREIGN KEY (scentinformation_id) REFERENCES scentinformation(id) ON DELETE CASCADE
);

CREATE TABLE fragrance_accord (
    fragrance_id INT,
    accord_id INT,
    PRIMARY KEY (fragrance_id, accord_id),
    FOREIGN KEY (fragrance_id) REFERENCES fragrance(id) ON DELETE CASCADE,
    FOREIGN KEY (accord_id) REFERENCES accord(id) ON DELETE CASCADE
);

CREATE TABLE scentinformation_topnote (
    scentinformation_id INT,
    note_id INT,
    PRIMARY KEY (scentinformation_id, note_id),
    FOREIGN KEY (scentinformation_id) REFERENCES scentinformation(id) ON DELETE CASCADE,
    FOREIGN KEY (note_id) REFERENCES note(id) ON DELETE CASCADE
);

CREATE TABLE scentinformation_middlenote (
    scentinformation_id INT,
    note_id INT,
    PRIMARY KEY (scentinformation_id, note_id),
    FOREIGN KEY (scentinformation_id) REFERENCES scentinformation(id) ON DELETE CASCADE,
    FOREIGN KEY (note_id) REFERENCES note(id) ON DELETE CASCADE
);

CREATE TABLE scentinformation_basenote (
    scentinformation_id INT,
    note_id INT,
    PRIMARY KEY (scentinformation_id, note_id),
    FOREIGN KEY (scentinformation_id) REFERENCES scentinformation(id) ON DELETE CASCADE,
    FOREIGN KEY (note_id) REFERENCES note(id) ON DELETE CASCADE
);

CREATE TABLE personalreview (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rating INT,
    sample_or_bottle VARCHAR(10),
    review TEXT,
    fragrance_id INT,
    FOREIGN KEY (fragrance_id) REFERENCES fragrance(id) ON DELETE CASCADE
);
