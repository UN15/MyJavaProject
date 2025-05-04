package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications){
		Map<String, Double> totalPrice = new HashMap<String, Double>();
		Map<String, Integer> totalCount = new HashMap<String, Integer>();
		Map<String, Double> totalAverage = new HashMap<String, Double>();

		for (Publication pub : publications) {
			if(getPublicationType(pub) == "소설") {
				totalPrice.put("소설", totalPrice.getOrDefault("소설", 0.0)+pub.getPrice());
				totalCount.put("소설", totalCount.getOrDefault("소설", 0)+1);
			}
			else if(getPublicationType(pub) == "잡지") {
				totalPrice.put("잡지", totalPrice.getOrDefault("잡지", 0.0)+pub.getPrice());
				totalCount.put("잡지", totalCount.getOrDefault("잡지", 0)+1);
			}
			else if(getPublicationType(pub) == "참고서") {
				totalPrice.put("참고서", totalPrice.getOrDefault("참고서", 0.0)+pub.getPrice());
				totalCount.put("참고서", totalCount.getOrDefault("참고서", 0)+1);
			}
		}
		totalAverage.put("소설", (totalPrice.get("소설")/totalCount.get("소설")));
		totalAverage.put("잡지", (totalPrice.get("잡지")/totalCount.get("잡지")));
		totalAverage.put("참고서", (totalPrice.get("참고서")/totalCount.get("참고서")));
		
		return totalAverage;
	}

	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
		Map<String, Integer> totalCount = new HashMap<String, Integer>();
		Map<String, Double> totalDistribution = new HashMap<String, Double>();
		int count = 0;
		for (Publication pub : publications) {
			if(getPublicationType(pub) == "소설") 
				totalCount.put("소설", totalCount.getOrDefault("소설", 0)+1);
			
			else if(getPublicationType(pub) == "잡지") 
				totalCount.put("잡지", totalCount.getOrDefault("잡지", 0)+1);
			
			else if(getPublicationType(pub) == "참고서") 
				totalCount.put("참고서", totalCount.getOrDefault("참고서", 0)+1);
			count++;
		}
		
		totalDistribution.put("소설",((double)totalCount.get("소설") /count) * 100);
		totalDistribution.put("잡지",((double)totalCount.get("잡지") /count) * 100);
		totalDistribution.put("참고서",((double)totalCount.get("참고서") /count) * 100);

		return totalDistribution;
	}

	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
		int countTotal = 0;
		int countYear = 0;
		for (Publication pub : publications) {
			String y = pub.getPublishDate().substring(0,4);
			if(year.equals(y))
				countYear++;
			countTotal++;
		}
		double result = ((double)countYear/countTotal)*100;
		return result;
	}

	private String getPublicationType(Publication pub) {
		if (pub instanceof Novel)
			return "소설";
		else if (pub instanceof Magazine)
			return "잡지";
		else if (pub instanceof ReferenceBook)
			return "참고서";
		else
			return "기타";
	}

	public void printStatistics(Publication[] publications) {
		DecimalFormat formatter = new DecimalFormat("#,###.##");
		System.out.println("\n===== 출판물 통계 분석 =====");
		System.out.println("1. 타입별 평균 가격:");
		Map<String, Double> totalAverage = calculateAveragePriceByType(publications);
		
		System.out.println("- 소설: "+  formatter.format(totalAverage.get("소설"))+"원");
		System.out.println("- 참고서: "+ formatter.format(totalAverage.get("참고서"))+"원");
		System.out.println("- 잡지: "+ formatter.format(totalAverage.get("잡지"))+"원");
		
		System.out.println("\n2. 출판물 유형 분포:");
		Map<String, Double> totalDistribution = calculatePublicationDistribution(publications);

		System.out.println("- 소설: "+ formatter.format(totalDistribution.get("소설"))+"%");
		System.out.println("- 참고서: "+ formatter.format(totalDistribution.get("참고서"))+"%");
		System.out.println("- 잡지: "+ formatter.format(totalDistribution.get("잡지"))+"%");
		
		System.out.println("\n3. 2007년에 출판된 출판물 비율: "+ formatter.format(calculatePublicationRatioByYear(publications, "2007"))+"%");
		System.out.println("=============================");

	}
}
