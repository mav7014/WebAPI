package org.ohdsi.webapi.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

/**
 * Test related to characterization services
 */
public class CharacterizationServiceIT extends WebApiIT {

    public static final String NYP_COLUMBIA5_54_DEID = "NYP-Columbia5.4-deid";

    public static String TEST_DATASOURCES = "{ \"datasources\": [  { \"name\":\"NYP-Columbia5.4-deid\", \"folder\":\"ohdsi_deid\" , \"cdmVersion\":5} ] }";

    public static String TEST_DASHBOARD = "{\"SUMMARY\":{\"ATTRIBUTE_NAME\":[\"Source name\",\"Number of persons\"],\"ATTRIBUTE_VALUE\":[\"NYP-Columbia5.4-deid\",\"5111022\"]},\"GENDER_DATA\":{\"CONCEPT_ID\":[8507,8532],\"CONCEPT_NAME\":[\"MALE\",\"FEMALE\"],\"COUNT_VALUE\":[2244526,2854071]},\"AGE_AT_FIRST_OBSERVATION_HISTOGRAM\":{\"MIN\":0,\"MAX\":100,\"INTERVAL_SIZE\":1,\"INTERVALS\":100,\"DATA\":{\"INTERVAL_INDEX\":[221,26,87,219,19,228,85,62,53,17,226,60,28,51,0,215,232,-16,15,66,32,49,230,81,64,47,30,13,217,83,23,6,55,38,24,224,41,73,5,-6,56,223,74,-7,69,3,-2,212,235,78,12,35,67,44,1,210,-11,10,42,76,-9,71,-4,237,37,-22,75,72,-5,21,58,-8,7,239,25,22,222,225,39,40,57,8,46,63,50,216,233,65,231,82,33,16,-15,48,31,214,80,14,29,218,229,86,43,236,18,61,4,211,79,36,11,54,68,-1,238,9,52,213,27,70,84,227,234,59,45,2,-3,77,-10,34,220,20],\"COUNT_VALUE\":[6688,45565,125,7369,31982,3386,801,17293,23633,26672,3209,18970,44637,24321,231179,15012,2495,13,23904,14350,40452,24942,3046,2254,14921,25211,43308,20477,9421,1526,43950,22656,22622,32129,45382,5139,29985,7228,24275,18,21962,5478,6522,28,11063,30456,76,7920,1809,3980,20736,36596,13073,27218,63125,15437,7,18473,28895,5052,15,8785,28,1551,33867,10,5967,8047,24,37223,20961,21,20583,1392,45558,40621,6218,4111,31315,30867,21573,18887,25985,16550,25074,12955,2025,14793,2673,1922,39344,24787,13,25627,42386,9652,2813,22016,44389,8133,3516,444,28194,1657,28923,18218,26517,11117,3294,35299,19545,22838,12193,190,1378,18746,23983,9209,45125,9729,1072,3502,1920,20041,26384,39615,68,4669,11,37906,7275,34725],\"PERCENT_VALUE\":[0.00131,0.00892,2e-005,0.00144,0.00626,0.00066,0.00016,0.00338,0.00462,0.00522,0.00063,0.00371,0.00873,0.00476,0.04523,0.00294,0.00049,0,0.00468,0.00281,0.00791,0.00488,0.0006,0.00044,0.00292,0.00493,0.00847,0.00401,0.00184,0.0003,0.0086,0.00443,0.00443,0.00629,0.00888,0.00101,0.00587,0.00141,0.00475,0,0.0043,0.00107,0.00128,1e-005,0.00216,0.00596,1e-005,0.00155,0.00035,0.00078,0.00406,0.00716,0.00256,0.00533,0.01235,0.00302,0,0.00361,0.00565,0.00099,0,0.00172,1e-005,0.0003,0.00663,0,0.00117,0.00157,0,0.00728,0.0041,0,0.00403,0.00027,0.00891,0.00795,0.00122,0.0008,0.00613,0.00604,0.00422,0.0037,0.00508,0.00324,0.00491,0.00253,0.0004,0.00289,0.00052,0.00038,0.0077,0.00485,0,0.00501,0.00829,0.00189,0.00055,0.00431,0.00868,0.00159,0.00069,9e-005,0.00552,0.00032,0.00566,0.00356,0.00519,0.00218,0.00064,0.00691,0.00382,0.00447,0.00239,4e-005,0.00027,0.00367,0.00469,0.0018,0.00883,0.0019,0.00021,0.00069,0.00038,0.00392,0.00516,0.00775,1e-005,0.00091,0,0.00742,0.00142,0.00679]}},\"CUMULATIVE_DURATION\":{\"SERIES_NAME\":[\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\",\"Length of observation\"],\"X_LENGTH_OF_OBSERVATION\":[0,30,60,90,120,150,180,210,240,270,300,330,360,390,420,450,480,510,540,570,600,630,660,690,720,750,780,810,840,870,900,930,960,990,1020,1050,1080,1110,1140,1170,1200,1230,1260,1290,1320,1350,1380,1410,1440,1470,1500,1530,1560,1590,1620,1650,1680,1710,1740,1770,1800,1830,1860,1890,1920,1950,1980,2010,2040,2070,2100,2130,2160,2190,2220,2250,2280,2310,2340,2370,2400,2430,2460,2490,2520,2550,2580,2610,2640,2670,2700,2730,2760,2790,2820,2850,2880,2910,2940,2970,3000,3030,3060,3090,3120,3150,3180,3210,3240,3270,3300,3330,3360,3390,3420,3450,3480,3510,3540,3570,3600,3630,3660,3690,3720,3750,3780,3810,3840,3870,3900,3930,3960,3990,4020,4050,4080,4110,4140,4170,4200,4230,4260,4290,4320,4350,4380,4410,4440,4470,4500,4530,4560,4590,4620,4650,4680,4710,4740,4770,4800,4830,4860,4890,4920,4950,4980,5010,5040,5070,5100,5130,5160,5190,5220,5250,5280,5310,5340,5370,5400,5430,5460,5490,5520,5550,5580,5610,5640,5670,5700,5730,5760,5790,5820,5850,5880,5910,5940,5970,6000,6030,6060,6090,6120,6150,6180,6210,6240,6270,6300,6330,6360,6390,6420,6450,6480,6510,6540,6570,6600,6630,6660,6690,6720,6750,6780,6810,6840,6870,6900,6930,6960,6990,7020,7050,7080,7110,7140,7170,7200,7230,7260,7290,7320,7350,7380,7410,7440,7470,7500,7530,7560,7590,7620,7650,7680,7710,7740,7770,7800,7830,7860,7890,7920,7950,7980,8010,8040,8070,8100,8130,8160,8190,8220,8250,8280,8310,8340,8370,8400,8430,8460,8490,8520,8550,8580,8610,8640,8670,8700,8730,8760,8790,8820,8850,8880,8910,8940,8970,9000,9030,9060,9090,9120,9150,9180,9210,9240,9270,9300,9330,9360,9390,9420,9450,9480,9510,9540,9570,9600,9630,9660,9690,9720,9750,9780,9810,9840,9870,9900,9930,9960,9990,10020,10050,10080,10110,10140,10170,10200,10230,10260,10290,10320,10350,10380,10410,10440,10470,10500,10530,10560,10590,10620,10650,10680,10710,10740,10770,10800,10830,10860,10890,10920],\"Y_PERCENT_PERSONS\":[0.4561,0.24656,0.23307,0.22473,0.21832,0.21314,0.20867,0.20418,0.20004,0.19651,0.19324,0.19022,0.18722,0.18378,0.18087,0.17817,0.17564,0.17327,0.17096,0.16868,0.16655,0.16448,0.16247,0.16051,0.1585,0.1563,0.15429,0.15244,0.15065,0.14888,0.14723,0.14555,0.14393,0.14236,0.14087,0.13936,0.13782,0.13627,0.13476,0.13328,0.13192,0.13058,0.1293,0.12798,0.1267,0.12545,0.12423,0.12303,0.12187,0.12063,0.11937,0.11819,0.11704,0.11592,0.11482,0.11373,0.11266,0.11158,0.11058,0.10958,0.10855,0.10749,0.10646,0.10542,0.10442,0.10345,0.10251,0.10155,0.1006,0.09969,0.09881,0.09793,0.09709,0.09625,0.09536,0.09455,0.09373,0.09292,0.0921,0.09131,0.09055,0.08977,0.08902,0.08827,0.08753,0.08677,0.08601,0.08527,0.08455,0.08382,0.08312,0.08244,0.08175,0.08108,0.08038,0.07971,0.07907,0.07842,0.07774,0.07708,0.07644,0.07581,0.07518,0.07454,0.07392,0.07332,0.07271,0.07211,0.07152,0.07095,0.07034,0.06975,0.06915,0.06858,0.06802,0.06746,0.0669,0.06635,0.06582,0.06528,0.06476,0.06424,0.0637,0.06318,0.06264,0.06212,0.06162,0.0611,0.06059,0.06009,0.05958,0.0591,0.05862,0.05813,0.05764,0.05713,0.05665,0.05616,0.0557,0.05524,0.05477,0.0543,0.05383,0.05338,0.05292,0.05246,0.05201,0.05156,0.0511,0.05065,0.05022,0.04979,0.04936,0.04896,0.04856,0.04815,0.04774,0.04733,0.04692,0.04652,0.04611,0.04572,0.04533,0.04494,0.04453,0.04413,0.04372,0.04335,0.04297,0.04259,0.04221,0.04184,0.04146,0.04109,0.04072,0.04035,0.04,0.03965,0.0393,0.03895,0.03859,0.03825,0.03789,0.03754,0.03719,0.03685,0.03651,0.03618,0.03585,0.03551,0.03519,0.03486,0.03455,0.03423,0.03391,0.03359,0.03328,0.03295,0.03262,0.03231,0.032,0.0317,0.03139,0.03108,0.03078,0.03047,0.03015,0.02984,0.02954,0.02925,0.02895,0.02865,0.02835,0.02804,0.02774,0.02744,0.02716,0.02688,0.02659,0.0263,0.02603,0.02575,0.02546,0.02519,0.02493,0.02466,0.02439,0.02413,0.02387,0.0236,0.02334,0.02307,0.02281,0.02255,0.02229,0.02205,0.02181,0.02156,0.02131,0.02106,0.02083,0.02059,0.02035,0.02012,0.01988,0.01965,0.01942,0.01919,0.01897,0.01876,0.01855,0.01834,0.0181,0.01787,0.01763,0.01741,0.01718,0.01696,0.01675,0.01653,0.01633,0.01612,0.01589,0.01569,0.01548,0.01527,0.01506,0.01485,0.01465,0.01444,0.01422,0.01401,0.0138,0.01359,0.01339,0.01318,0.01298,0.01278,0.01258,0.01237,0.01216,0.01196,0.01175,0.01155,0.01135,0.01115,0.01095,0.01075,0.01056,0.01035,0.01015,0.00996,0.00975,0.00956,0.00937,0.00917,0.00897,0.00878,0.00859,0.00841,0.00824,0.00806,0.0079,0.00775,0.00759,0.00744,0.00728,0.00712,0.00697,0.00681,0.00666,0.00651,0.00637,0.00623,0.00607,0.00593,0.00578,0.00564,0.0055,0.00537,0.00522,0.00508,0.00495,0.00481,0.00467,0.00455,0.00442,0.0043,0.00416,0.00404,0.0039,0.00377,0.00364,0.00352,0.00339,0.00326,0.00313,0.003,0.00286,0.00273,0.0026,0.00248,0.00236,0.00222,0.00209,0.00197,0.00184,0.00171,0.00159,0.00145,0.00131,0.00118,0.00105,0.00091,0.00078,0.00066,0.00054,0.00043,0.00033,0.00025,0.00018,0.00011,7e-005,3e-005,1e-005]},\"OBSERVED_BY_MONTH\":{\"MONTH_YEAR\":[198608,198610,198708,198710,198808,198810,198908,198910,199008,199010,199012,199110,199112,199210,199212,199310,199312,199410,199412,199510,199512,199610,199612,199710,199712,199812,199912,200012,200112,200212,200312,200412,200512,201101,201201,201301,201401,201501,198611,198803,198903,199003,199103,199203,199204,199303,199304,199403,199404,199503,199504,199603,199604,199703,199704,199803,199804,199903,199904,200003,200004,200103,200104,200203,200204,200304,200307,200404,200407,200504,200507,200604,200607,200608,200707,200708,200807,200808,200907,200908,201007,201008,201107,201108,201207,201208,201307,201308,201407,201408,201507,201508,198604,198606,198704,198706,198804,198806,198904,198906,199004,199006,199104,199106,199108,199206,199208,199306,199308,199406,199408,199506,199508,199601,199606,199608,199701,199706,199708,199801,199806,199808,199810,199901,199908,199910,200001,200008,200010,200101,200108,200110,200201,200208,200210,200301,200303,200308,200310,200401,200403,200408,200410,200501,200503,200508,200510,200601,200603,200610,200612,200701,200703,200710,200712,200801,200803,200810,200812,200901,200903,200910,200912,201001,201003,201005,201010,201012,201103,201105,201110,201112,201203,201205,201210,201212,201303,201305,201312,201403,201405,201412,201503,201505,201512,198607,198609,198709,198711,198809,198811,198909,198911,199009,199011,199109,199111,199209,199211,199309,199311,199409,199411,199511,199611,199711,199811,199911,200011,200111,201502,198605,198612,198705,198712,198805,198812,198905,198912,199005,199105,199205,199305,199405,199509,199609,199709,199809,199909,200002,200009,200102,200109,200202,200209,200302,200309,200402,200409,200502,200509,200602,200609,200702,200709,200802,200809,200902,200909,201002,201102,201202,201302,201402,201406,201506,198602,198701,198702,198801,198802,198901,198902,199001,199002,199101,199102,199201,199202,199301,199302,199401,199402,199501,199502,199505,199602,199605,199702,199705,199802,199805,199902,199905,199906,200005,200006,200105,200106,200205,200206,200305,200306,200405,200406,200505,200506,200605,200606,200705,200706,200805,200806,200905,200906,201006,201009,201106,201109,201206,201209,201306,201309,201310,201409,201410,201509,201510,198603,198703,198707,198807,198907,199007,199107,199207,199307,199407,199507,199607,199707,199807,199907,200007,200107,200207,200211,200311,200411,200511,200611,200704,200711,200804,200811,200904,200911,201004,201011,201104,201111,201204,201211,201304,201311,201404,201411,201504,201511],\"COUNT_VALUE\":[32413,45943,98340,104821,130659,135067,155603,159853,179771,183354,187062,211646,216928,236224,239054,252229,254525,265837,267794,277855,279923,292794,295488,307576,309653,321787,333393,339806,345053,356381,367214,376976,382358,355800,335338,309885,273346,210036,53222,118694,145309,170093,193642,223755,226010,243185,244652,257901,259116,270793,271914,283438,284743,299674,301136,312814,313872,325036,326133,335380,336022,340878,341314,347479,348531,359825,362667,370723,373107,379481,380792,382845,382682,382620,380424,380235,377491,377114,372763,372126,362960,361707,346592,344918,323487,321207,293690,290551,247877,242545,145357,128739,10129,20275,82961,91256,121282,126220,147438,151507,172102,175911,196153,201336,206507,229665,233035,247286,249734,261386,263596,274040,275917,281026,287287,290037,297084,303327,305349,310678,315715,317713,319828,322974,329922,331450,334138,338275,339091,340158,342727,343825,345811,352389,354360,357271,359004,363560,365373,368001,369697,373966,375444,377618,378752,381244,381987,382616,382663,382287,382016,381890,381343,379793,379296,378889,378539,376388,375845,375522,374614,370716,369296,368408,366354,364600,359528,357097,352999,349965,341182,337268,331273,327326,316741,312308,304845,299455,276999,265960,257145,217897,192839,171875,2822,26028,39148,101814,107907,132866,137177,157859,161984,181640,185354,209186,214396,234767,237795,251081,253510,264807,266910,279006,294302,308794,320948,332523,339521,344610,202630,14945,60262,87217,110752,123744,139123,149370,164061,173989,198589,227785,245975,260158,276934,291484,306528,318777,330765,335032,338765,340931,343386,346924,353497,358437,364530,369200,374756,378559,381768,383013,382608,382032,380133,378828,376843,375492,371593,367722,354894,333583,307835,270116,252975,159603,2542,67246,73496,113485,116275,141215,143511,166181,168331,189191,191648,219324,221871,240590,242153,255685,257092,268826,270075,272910,282321,285873,298760,302237,312031,314592,324197,327007,327996,336553,337335,341579,341945,349348,350472,360721,361807,371524,372354,380057,380615,382717,382754,380892,380756,377983,377820,373965,373583,364013,360790,348334,343165,325656,319168,296737,287432,284024,237310,231122,110024,85816,5757,78175,94801,128464,153489,177798,203886,231303,248461,262425,274974,288615,304264,316639,328806,337798,342273,351415,355508,366414,376385,382307,382335,381315,379641,378391,376205,374474,370140,365688,358480,351720,339463,329417,314736,302252,280565,261782,224879,183073,55315],\"PERCENT_VALUE\":[0.00634,0.00899,0.01924,0.02051,0.02556,0.02643,0.03044,0.03128,0.03517,0.03587,0.0366,0.04141,0.04244,0.04622,0.04677,0.04935,0.0498,0.05201,0.0524,0.05436,0.05477,0.05729,0.05781,0.06018,0.06059,0.06296,0.06523,0.06648,0.06751,0.06973,0.07185,0.07376,0.07481,0.06961,0.06561,0.06063,0.05348,0.04109,0.01041,0.02322,0.02843,0.03328,0.03789,0.04378,0.04422,0.04758,0.04787,0.05046,0.0507,0.05298,0.0532,0.05546,0.05571,0.05863,0.05892,0.0612,0.06141,0.0636,0.06381,0.06562,0.06574,0.06669,0.06678,0.06799,0.06819,0.0704,0.07096,0.07253,0.073,0.07425,0.0745,0.07491,0.07487,0.07486,0.07443,0.0744,0.07386,0.07378,0.07293,0.07281,0.07102,0.07077,0.06781,0.06749,0.06329,0.06285,0.05746,0.05685,0.0485,0.04746,0.02844,0.02519,0.00198,0.00397,0.01623,0.01785,0.02373,0.0247,0.02885,0.02964,0.03367,0.03442,0.03838,0.03939,0.0404,0.04494,0.04559,0.04838,0.04886,0.05114,0.05157,0.05362,0.05398,0.05498,0.05621,0.05675,0.05813,0.05935,0.05974,0.06079,0.06177,0.06216,0.06258,0.06319,0.06455,0.06485,0.06538,0.06619,0.06635,0.06655,0.06706,0.06727,0.06766,0.06895,0.06933,0.0699,0.07024,0.07113,0.07149,0.072,0.07233,0.07317,0.07346,0.07388,0.0741,0.07459,0.07474,0.07486,0.07487,0.0748,0.07474,0.07472,0.07461,0.07431,0.07421,0.07413,0.07406,0.07364,0.07354,0.07347,0.0733,0.07253,0.07225,0.07208,0.07168,0.07134,0.07034,0.06987,0.06907,0.06847,0.06675,0.06599,0.06482,0.06404,0.06197,0.0611,0.05964,0.05859,0.0542,0.05204,0.05031,0.04263,0.03773,0.03363,0.00055,0.00509,0.00766,0.01992,0.02111,0.026,0.02684,0.03089,0.03169,0.03554,0.03627,0.04093,0.04195,0.04593,0.04653,0.04913,0.0496,0.05181,0.05222,0.05459,0.05758,0.06042,0.0628,0.06506,0.06643,0.06742,0.03965,0.00292,0.01179,0.01706,0.02167,0.02421,0.02722,0.02923,0.0321,0.03404,0.03886,0.04457,0.04813,0.0509,0.05418,0.05703,0.05997,0.06237,0.06472,0.06555,0.06628,0.06671,0.06719,0.06788,0.06916,0.07013,0.07132,0.07224,0.07332,0.07407,0.0747,0.07494,0.07486,0.07475,0.07438,0.07412,0.07373,0.07347,0.0727,0.07195,0.06944,0.06527,0.06023,0.05285,0.0495,0.03123,0.0005,0.01316,0.01438,0.0222,0.02275,0.02763,0.02808,0.03251,0.03293,0.03702,0.0375,0.04291,0.04341,0.04707,0.04738,0.05003,0.0503,0.0526,0.05284,0.0534,0.05524,0.05593,0.05845,0.05913,0.06105,0.06155,0.06343,0.06398,0.06417,0.06585,0.066,0.06683,0.0669,0.06835,0.06857,0.07058,0.07079,0.07269,0.07285,0.07436,0.07447,0.07488,0.07489,0.07452,0.0745,0.07395,0.07392,0.07317,0.07309,0.07122,0.07059,0.06815,0.06714,0.06372,0.06245,0.05806,0.05624,0.05557,0.04643,0.04522,0.02153,0.01679,0.00113,0.0153,0.01855,0.02513,0.03003,0.03479,0.03989,0.04526,0.04861,0.05134,0.0538,0.05647,0.05953,0.06195,0.06433,0.06609,0.06697,0.06876,0.06956,0.07169,0.07364,0.0748,0.07481,0.07461,0.07428,0.07403,0.07361,0.07327,0.07242,0.07155,0.07014,0.06882,0.06642,0.06445,0.06158,0.05914,0.05489,0.05122,0.044,0.03582,0.01082]}}\n";

    @Value("${characterization.endpoint}")
    private String endpointCharacterizations;

    /**
     * @throws Exception
     */
    @Test
    public void testDataSources() throws Exception {
        final ResponseEntity<String> getEntity = getRestTemplate().getForEntity(this.endpointCharacterizations + "/datasources",
                String.class);
        assertOk(getEntity);
        log.info(getEntity.getBody());

        Assert.state(getEntity.equals(CharacterizationServiceIT.TEST_DATASOURCES));
    }


    /**
     * @throws Exception
     */
    @Test
    public void testDashboard() throws Exception {
        log.info("Testing " + endpointCharacterizations + " endpoint");
        final ResponseEntity<String> getEntity = getRestTemplate().getForEntity(this.endpointCharacterizations + "/" + NYP_COLUMBIA5_54_DEID + "/dashboard", String.class);
        assertOk(getEntity);
        log.info(getEntity.getBody());
        Assert.state(getEntity.equals(CharacterizationServiceIT.TEST_DASHBOARD));

    }

    private void assertOk(final ResponseEntity<?> entity) {
        Assert.state(entity.getStatusCode() == HttpStatus.OK);
    }

//    @Test
//    public void testHeel() {
//        log.info("Testing " + this.endpointCharacterizations + "/heel" + " endpoint");
//        final ResponseEntity<String> entity = getRestTemplate().getForEntity(this.endpointCharacterizations + "/NYP-Columbia5.4-deid/" + "heel", String.class);
//    }

}