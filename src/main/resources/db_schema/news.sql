CREATE TABLE article(
  article_id INT NOT NULL,
  content CHAR(255),
  publicatioin_date DATE,
  PRIMARY KEY (article_id)
);

CREATE TABLE category(
  category_id INT NOT NULL,
  name CHAR(21),
  article INT,
  PRIMARY KEY (category_id),
  CONSTRAINT fk_article FOREIGN KEY (article)
    REFERENCES article (article_id)
);