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
			if(getPublicationType(pub) == "�Ҽ�") {
				totalPrice.put("�Ҽ�", totalPrice.getOrDefault("�Ҽ�", 0.0)+pub.getPrice());
				totalCount.put("�Ҽ�", totalCount.getOrDefault("�Ҽ�", 0)+1);
			}
			else if(getPublicationType(pub) == "����") {
				totalPrice.put("����", totalPrice.getOrDefault("����", 0.0)+pub.getPrice());
				totalCount.put("����", totalCount.getOrDefault("����", 0)+1);
			}
			else if(getPublicationType(pub) == "����") {
				totalPrice.put("����", totalPrice.getOrDefault("����", 0.0)+pub.getPrice());
				totalCount.put("����", totalCount.getOrDefault("����", 0)+1);
			}
		}
		totalAverage.put("�Ҽ�", (totalPrice.get("�Ҽ�")/totalCount.get("�Ҽ�")));
		totalAverage.put("����", (totalPrice.get("����")/totalCount.get("����")));
		totalAverage.put("����", (totalPrice.get("����")/totalCount.get("����")));
		
		return totalAverage;
	}

	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
		Map<String, Integer> totalCount = new HashMap<String, Integer>();
		Map<String, Double> totalDistribution = new HashMap<String, Double>();
		int count = 0;
		for (Publication pub : publications) {
			if(getPublicationType(pub) == "�Ҽ�") 
				totalCount.put("�Ҽ�", totalCount.getOrDefault("�Ҽ�", 0)+1);
			
			else if(getPublicationType(pub) == "����") 
				totalCount.put("����", totalCount.getOrDefault("����", 0)+1);
			
			else if(getPublicationType(pub) == "����") 
				totalCount.put("����", totalCount.getOrDefault("����", 0)+1);
			count++;
		}
		
		totalDistribution.put("�Ҽ�",((double)totalCount.get("�Ҽ�") /count) * 100);
		totalDistribution.put("����",((double)totalCount.get("����") /count) * 100);
		totalDistribution.put("����",((double)totalCount.get("����") /count) * 100);

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
			return "�Ҽ�";
		else if (pub instanceof Magazine)
			return "����";
		else if (pub instanceof ReferenceBook)
			return "����";
		else
			return "��Ÿ";
	}

	public void printStatistics(Publication[] publications) {
		DecimalFormat formatter = new DecimalFormat("#,###.##");
		System.out.println("\n===== ���ǹ� ��� �м� =====");
		System.out.println("1. Ÿ�Ժ� ��� ����:");
		Map<String, Double> totalAverage = calculateAveragePriceByType(publications);
		
		System.out.println("- �Ҽ�: "+  formatter.format(totalAverage.get("�Ҽ�"))+"��");
		System.out.println("- ����: "+ formatter.format(totalAverage.get("����"))+"��");
		System.out.println("- ����: "+ formatter.format(totalAverage.get("����"))+"��");
		
		System.out.println("\n2. ���ǹ� ���� ����:");
		Map<String, Double> totalDistribution = calculatePublicationDistribution(publications);

		System.out.println("- �Ҽ�: "+ formatter.format(totalDistribution.get("�Ҽ�"))+"%");
		System.out.println("- ����: "+ formatter.format(totalDistribution.get("����"))+"%");
		System.out.println("- ����: "+ formatter.format(totalDistribution.get("����"))+"%");
		
		System.out.println("\n3. 2007�⿡ ���ǵ� ���ǹ� ����: "+ formatter.format(calculatePublicationRatioByYear(publications, "2007"))+"%");
		System.out.println("=============================");

	}
}
