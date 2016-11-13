SELECT
  c1.concept_id                                                AS concept_id,
  c1.concept_name                                              AS concept_name,
  num.stratum_2                                                AS x_calendar_month,
  round(1000 * (1.0 * num.count_value / denom.count_value), 5) AS y_prevalence_1000pp
FROM
  (SELECT *
   FROM @results_database_schema.ACHILLES_results WHERE analysis_id = 702) num
  INNER JOIN
  (SELECT *
   FROM @results_database_schema.ACHILLES_results WHERE analysis_id = 117) denom
    ON num.stratum_2 = denom.stratum_1
  --calendar year
  INNER JOIN
  @vocab_database_schema.concept c1
ON num.stratum_1 = CAST(c1.concept_id AS VARCHAR )