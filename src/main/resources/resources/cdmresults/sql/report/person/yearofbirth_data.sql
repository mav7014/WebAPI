SELECT
  cast(ar1.stratum_1 AS INT) - MinValue.MinValue      AS interval_index,
  ar1.count_value                                     AS count_value,
  round(1.0 * ar1.count_value / denom.count_value, 5) AS percent_value
FROM (SELECT *
      FROM @results_database_schema.ACHILLES_results WHERE analysis_id = 3) ar1,
  (SELECT min(cast(stratum_1 AS INT)) AS MinValue
   FROM @results_database_schema.ACHILLES_results WHERE analysis_id = 3) MinValue,
  (SELECT count_value
   FROM @results_database_schema.ACHILLES_results WHERE analysis_id = 1) denom
ORDER BY ar1.stratum_1 ASC
