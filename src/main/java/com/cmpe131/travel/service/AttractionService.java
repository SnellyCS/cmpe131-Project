// Added by Khai Nguyen
package com.cmpe131.travel.service;

import com.cmpe131.travel.dto.AttractionDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttractionService {

    // Maps normalized city label → list of base attractions (priced per 1 adult)
    private static final Map<String, List<AttractionDTO>> ATTRACTION_INVENTORY = new HashMap<>();

    static {
        // ── Paris ────────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Paris, France", List.of(
                new AttractionDTO("PAR-1", "Eiffel Tower Skip-the-Line Tour", "culture", "🏛️",
                        "Paris, France", "3h", 45.00, 45.00, 30, "4.9", 8421,
                        "Skip the queue and ascend the iconic Eiffel Tower with a knowledgeable guide."),
                new AttractionDTO("PAR-2", "Louvre Museum Guided Tour", "culture", "🏛️",
                        "Paris, France", "2.5h", 38.00, 38.00, 20, "4.8", 6130,
                        "Explore the world's largest art museum including the Mona Lisa and Venus de Milo."),
                new AttractionDTO("PAR-3", "Seine River Dinner Cruise", "culinary", "🍷",
                        "Paris, France", "2h", 89.00, 89.00, 150, "4.7", 3874,
                        "Enjoy a gourmet French dinner while cruising past Paris's illuminated landmarks."),
                new AttractionDTO("PAR-4", "Montmartre Street Art Walking Tour", "sightseeing", "📸",
                        "Paris, France", "2h", 22.00, 22.00, 15, "4.6", 2105,
                        "Wander the charming cobblestone streets of Montmartre with a local artist guide."),
                new AttractionDTO("PAR-5", "Versailles Palace Day Trip", "culture", "🏛️",
                        "Paris, France", "8h", 65.00, 65.00, 25, "4.8", 5312,
                        "Visit the magnificent Palace of Versailles and its breathtaking gardens.")
        ));

        // ── London ───────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("London, UK", List.of(
                new AttractionDTO("LON-1", "Tower of London & Crown Jewels Tour", "culture", "🏛️",
                        "London, UK", "3h", 42.00, 42.00, 20, "4.8", 7230,
                        "Discover 1,000 years of royal history and see the priceless Crown Jewels up close."),
                new AttractionDTO("LON-2", "Thames River Sunset Cruise", "sightseeing", "📸",
                        "London, UK", "1.5h", 28.00, 28.00, 200, "4.6", 4521,
                        "See London's skyline from the river at golden hour — Tower Bridge, Big Ben, and more."),
                new AttractionDTO("LON-3", "Harry Potter Warner Bros. Studio Tour", "family", "👨‍👩‍👧‍👦",
                        "London, UK", "4h", 55.00, 55.00, 50, "4.9", 9102,
                        "Step behind the scenes of the Harry Potter films at the original studio."),
                new AttractionDTO("LON-4", "West End Musical Evening", "culture", "🏛️",
                        "London, UK", "3h", 75.00, 75.00, 100, "4.7", 3340,
                        "Enjoy a top West End show — one of the greatest theatre districts in the world."),
                new AttractionDTO("LON-5", "Borough Market Food Tour", "culinary", "🍷",
                        "London, UK", "2h", 35.00, 35.00, 12, "4.8", 2089,
                        "Taste your way through London's iconic food market with a passionate local guide.")
        ));

        // ── New York ─────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("New York, USA", List.of(
                new AttractionDTO("NYC-1", "Statue of Liberty & Ellis Island Ferry", "culture", "🏛️",
                        "New York, USA", "4h", 39.00, 39.00, 40, "4.7", 6800,
                        "Visit America's most iconic landmark and explore the Ellis Island immigration museum."),
                new AttractionDTO("NYC-2", "Top of the Rock Observatory", "sightseeing", "📸",
                        "New York, USA", "1.5h", 40.00, 40.00, 200, "4.8", 5411,
                        "360-degree panoramic views of Manhattan from Rockefeller Center's observation deck."),
                new AttractionDTO("NYC-3", "NYC Food & Culture Walking Tour", "culinary", "🍷",
                        "New York, USA", "3h", 49.00, 49.00, 15, "4.8", 2930,
                        "Sample New York's diverse cuisine through Chelsea Market, Little Italy, and Chinatown."),
                new AttractionDTO("NYC-4", "Central Park Bike Rental", "nature", "🌿",
                        "New York, USA", "2h", 18.00, 18.00, 30, "4.5", 4120,
                        "Explore 843 acres of urban parkland at your own pace on a classic city bike."),
                new AttractionDTO("NYC-5", "Broadway Show Experience", "culture", "🏛️",
                        "New York, USA", "3h", 110.00, 110.00, 100, "4.9", 8800,
                        "Experience the magic of Broadway — the pinnacle of live musical theatre.")
        ));

        // ── Tokyo ────────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Tokyo, Japan", List.of(
                new AttractionDTO("TYO-1", "Tsukiji Outer Market Food Tour", "culinary", "🍷",
                        "Tokyo, Japan", "3h", 65.00, 65.00, 12, "4.9", 4200,
                        "Taste fresh sushi, tamagoyaki, and street snacks at Tokyo's legendary fish market."),
                new AttractionDTO("TYO-2", "teamLab Planets Immersive Art", "culture", "🏛️",
                        "Tokyo, Japan", "2h", 32.00, 32.00, 50, "4.8", 5900,
                        "Walk through stunning digital art installations in a fully immersive environment."),
                new AttractionDTO("TYO-3", "Senso-ji Temple Morning Walk", "culture", "🏛️",
                        "Tokyo, Japan", "2h", 28.00, 28.00, 15, "4.7", 3300,
                        "Explore Tokyo's oldest Buddhist temple in Asakusa with a local history guide."),
                new AttractionDTO("TYO-4", "Akihabara Anime & Tech Tour", "sightseeing", "📸",
                        "Tokyo, Japan", "2.5h", 35.00, 35.00, 10, "4.6", 1870,
                        "Dive into anime culture, retro arcades, and electronics shops with a local fan guide."),
                new AttractionDTO("TYO-5", "Mt. Fuji Day Trip", "nature", "🌿",
                        "Tokyo, Japan", "10h", 85.00, 85.00, 20, "4.9", 7100,
                        "Visit Japan's most iconic mountain with a full-day guided excursion from Tokyo.")
        ));

        // ── Los Angeles ──────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Los Angeles, USA", List.of(
                new AttractionDTO("LAX-1", "Warner Bros. Studio Tour", "culture", "🏛️",
                        "Los Angeles, USA", "3h", 69.00, 69.00, 30, "4.8", 6200,
                        "Go behind the scenes of Hollywood's most legendary film and TV studio."),
                new AttractionDTO("LAX-2", "Santa Monica Pier & Beach Bike Tour", "nature", "🌿",
                        "Los Angeles, USA", "2.5h", 25.00, 25.00, 20, "4.6", 3800,
                        "Ride the iconic beachside path from Santa Monica to Venice Beach."),
                new AttractionDTO("LAX-3", "Griffith Observatory Night Tour", "sightseeing", "📸",
                        "Los Angeles, USA", "2h", 30.00, 30.00, 25, "4.7", 2900,
                        "Stargaze over the LA skyline with telescope access and expert astronomy talks."),
                new AttractionDTO("LAX-4", "LA Food & Film Neighborhoods Tour", "culinary", "🍷",
                        "Los Angeles, USA", "4h", 55.00, 55.00, 15, "4.7", 1980,
                        "Eat your way through Silver Lake, Koreatown, and Los Feliz with a local foodie."),
                new AttractionDTO("LAX-5", "Universal Studios Hollywood", "family", "👨‍👩‍👧‍👦",
                        "Los Angeles, USA", "8h", 109.00, 109.00, 100, "4.6", 11200,
                        "Full day at Universal Studios with rides, shows, and the Wizarding World of Harry Potter.")
        ));

        // ── San Francisco ────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("San Francisco, USA", List.of(
                new AttractionDTO("SFO-1", "Alcatraz Island Tour", "culture", "🏛️",
                        "San Francisco, USA", "3h", 49.00, 49.00, 30, "4.9", 8900,
                        "Explore the infamous island prison with an award-winning audio tour."),
                new AttractionDTO("SFO-2", "Golden Gate Bridge Bike Ride", "nature", "🌿",
                        "San Francisco, USA", "3h", 35.00, 35.00, 20, "4.8", 5600,
                        "Cycle across the Golden Gate Bridge and into Sausalito with stunning bay views."),
                new AttractionDTO("SFO-3", "Chinatown & North Beach Food Walk", "culinary", "🍷",
                        "San Francisco, USA", "2.5h", 42.00, 42.00, 12, "4.7", 2100,
                        "Sample dim sum, sourdough, and Italian pastries in SF's most storied neighborhoods."),
                new AttractionDTO("SFO-4", "Wine Country Day Trip (Napa/Sonoma)", "culinary", "🍷",
                        "San Francisco, USA", "9h", 125.00, 125.00, 15, "4.8", 3900,
                        "Visit world-class wineries in Napa or Sonoma Valley on a guided day trip."),
                new AttractionDTO("SFO-5", "Bay Sunset Sailing Cruise", "relaxation", "🧘",
                        "San Francisco, USA", "2h", 65.00, 65.00, 20, "4.7", 1800,
                        "Sail under the Golden Gate Bridge at sunset with wine and light snacks.")
        ));

        // ── Miami ────────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Miami, USA", List.of(
                new AttractionDTO("MIA-1", "Art Deco Walking Tour, South Beach", "culture", "🏛️",
                        "Miami, USA", "2h", 25.00, 25.00, 15, "4.7", 2800,
                        "Walk through the largest collection of Art Deco architecture in the world."),
                new AttractionDTO("MIA-2", "Everglades Airboat Adventure", "adventure", "🧗",
                        "Miami, USA", "4h", 55.00, 55.00, 20, "4.8", 4100,
                        "Zoom across the Florida Everglades on an airboat and spot alligators up close."),
                new AttractionDTO("MIA-3", "Wynwood Walls Street Art Tour", "culture", "🏛️",
                        "Miami, USA", "2h", 20.00, 20.00, 15, "4.6", 2200,
                        "Discover Miami's world-famous open-air street art museum with a local guide."),
                new AttractionDTO("MIA-4", "Miami Beach Kayak & Snorkel Tour", "adventure", "🧗",
                        "Miami, USA", "3h", 65.00, 65.00, 12, "4.7", 1600,
                        "Kayak through crystal-clear waters and snorkel over vibrant Miami reef systems."),
                new AttractionDTO("MIA-5", "Little Havana Food & Culture Tour", "culinary", "🍷",
                        "Miami, USA", "2.5h", 45.00, 45.00, 12, "4.8", 1900,
                        "Taste Cuban coffee, cigars, and street food in Miami's vibrant Cuban quarter.")
        ));

        // ── Chicago ──────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Chicago, USA", List.of(
                new AttractionDTO("CHI-1", "Chicago Architecture River Cruise", "culture", "🏛️",
                        "Chicago, USA", "1.5h", 47.00, 47.00, 150, "4.9", 9400,
                        "Cruise the Chicago River and hear the stories behind 50+ landmark skyscrapers."),
                new AttractionDTO("CHI-2", "Deep-Dish Pizza & Food Tour", "culinary", "🍷",
                        "Chicago, USA", "3h", 39.00, 39.00, 12, "4.8", 3100,
                        "Sample Chicago's legendary deep-dish pizza and diverse neighborhood cuisine."),
                new AttractionDTO("CHI-3", "Millennium Park & The Bean Bike Tour", "sightseeing", "📸",
                        "Chicago, USA", "2.5h", 28.00, 28.00, 15, "4.6", 2700,
                        "Cycle the Lakefront Trail past Millennium Park, Navy Pier, and the Museum Campus."),
                new AttractionDTO("CHI-4", "360 Chicago Observatory", "sightseeing", "📸",
                        "Chicago, USA", "1h", 30.00, 30.00, 50, "4.7", 4200,
                        "Tilt out over the city on the TILT experience at the John Hancock Center.")
        ));

        // ── Dubai ────────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Dubai, UAE", List.of(
                new AttractionDTO("DXB-1", "Burj Khalifa 'At the Top' Experience", "sightseeing", "📸",
                        "Dubai, UAE", "1.5h", 55.00, 55.00, 50, "4.8", 7800,
                        "Ascend the world's tallest building to the 124th-floor observation deck."),
                new AttractionDTO("DXB-2", "Desert Safari with BBQ Dinner", "adventure", "🧗",
                        "Dubai, UAE", "6h", 75.00, 75.00, 30, "4.9", 11200,
                        "Dune bash, ride camels, and dine under the stars in the Arabian desert."),
                new AttractionDTO("DXB-3", "Dubai Creek & Souk Heritage Tour", "culture", "🏛️",
                        "Dubai, UAE", "3h", 38.00, 38.00, 15, "4.7", 3300,
                        "Explore the historic Gold and Spice Souks and cross the creek on an abra."),
                new AttractionDTO("DXB-4", "Dubai Frame & Downtown Walk", "sightseeing", "📸",
                        "Dubai, UAE", "2h", 20.00, 20.00, 20, "4.5", 2600,
                        "Walk across the glass bridge of the Dubai Frame for views of old and new Dubai."),
                new AttractionDTO("DXB-5", "Dhow Cruise Dinner on Dubai Creek", "culinary", "🍷",
                        "Dubai, UAE", "2h", 60.00, 60.00, 80, "4.7", 4900,
                        "Enjoy a traditional dinner aboard a wooden dhow cruising past lit-up skyscrapers.")
        ));

        // ── Sydney ───────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Sydney, Australia", List.of(
                new AttractionDTO("SYD-1", "Sydney Opera House Guided Tour", "culture", "🏛️",
                        "Sydney, Australia", "1.5h", 43.00, 43.00, 20, "4.8", 5700,
                        "Go behind the sails of one of the world's most recognisable buildings."),
                new AttractionDTO("SYD-2", "Bondi to Coogee Coastal Walk", "nature", "🌿",
                        "Sydney, Australia", "3h", 22.00, 22.00, 15, "4.7", 3900,
                        "Walk the stunning 6km coastal trail past iconic beaches and headland lookouts."),
                new AttractionDTO("SYD-3", "Sydney Harbour Sailing Adventure", "adventure", "🧗",
                        "Sydney, Australia", "3h", 89.00, 89.00, 20, "4.9", 4100,
                        "Sail on the harbour with the Bridge and Opera House as your backdrop."),
                new AttractionDTO("SYD-4", "Blue Mountains Day Trip", "nature", "🌿",
                        "Sydney, Australia", "10h", 99.00, 99.00, 20, "4.8", 6200,
                        "Explore the dramatic Three Sisters rock formation and ancient eucalyptus forests.")
        ));

        // ── Singapore ────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Singapore", List.of(
                new AttractionDTO("SIN-1", "Gardens by the Bay Night Tour", "nature", "🌿",
                        "Singapore", "2h", 30.00, 30.00, 20, "4.9", 6800,
                        "Walk among the towering Supertrees and watch the spectacular light show."),
                new AttractionDTO("SIN-2", "Singapore Hawker Centre Food Tour", "culinary", "🍷",
                        "Singapore", "3h", 55.00, 55.00, 10, "4.9", 4500,
                        "Eat your way through Singapore's UNESCO-listed hawker culture — laksa, chilli crab, and more."),
                new AttractionDTO("SIN-3", "Universal Studios Singapore", "family", "👨‍👩‍👧‍👦",
                        "Singapore", "8h", 79.00, 79.00, 50, "4.7", 9300,
                        "Full day of rides and shows at Southeast Asia's only Universal Studios park."),
                new AttractionDTO("SIN-4", "Chinatown & Little India Heritage Walk", "culture", "🏛️",
                        "Singapore", "2.5h", 25.00, 25.00, 15, "4.7", 2400,
                        "Discover Singapore's multicultural roots through its most colourful historic districts.")
        ));

        // ── Seoul ────────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Seoul, South Korea", List.of(
                new AttractionDTO("ICN-1", "Gyeongbokgung Palace & Hanbok Tour", "culture", "🏛️",
                        "Seoul, South Korea", "3h", 35.00, 35.00, 15, "4.8", 5100,
                        "Wear a traditional hanbok and explore the grandest of Seoul's Five Grand Palaces."),
                new AttractionDTO("ICN-2", "Korean Street Food Night Tour", "culinary", "🍷",
                        "Seoul, South Korea", "3h", 48.00, 48.00, 10, "4.9", 3700,
                        "Taste tteokbokki, Korean fried chicken, and hotteok at Gwangjang and Myeongdong markets."),
                new AttractionDTO("ICN-3", "K-Pop & Hallyu Culture Experience", "culture", "🏛️",
                        "Seoul, South Korea", "2h", 30.00, 30.00, 10, "4.7", 2800,
                        "Learn K-pop dance moves and visit the hottest fan spots in Gangnam and Hongdae."),
                new AttractionDTO("ICN-4", "DMZ & Joint Security Area Tour", "culture", "🏛️",
                        "Seoul, South Korea", "8h", 75.00, 75.00, 30, "4.8", 6200,
                        "Visit the world's most heavily guarded border and peer into North Korea.")
        ));

        // ── Bangkok ──────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Bangkok, Thailand", List.of(
                new AttractionDTO("BKK-1", "Grand Palace & Wat Pho Tour", "culture", "🏛️",
                        "Bangkok, Thailand", "4h", 35.00, 35.00, 15, "4.8", 6900,
                        "Explore Thailand's most sacred sites — the Grand Palace and the giant Reclining Buddha."),
                new AttractionDTO("BKK-2", "Bangkok Street Food Night Tour", "culinary", "🍷",
                        "Bangkok, Thailand", "3h", 40.00, 40.00, 10, "4.9", 5200,
                        "Taste pad thai, mango sticky rice, and boat noodles on a guided night market crawl."),
                new AttractionDTO("BKK-3", "Chao Phraya River & Klongs Boat Tour", "sightseeing", "📸",
                        "Bangkok, Thailand", "2.5h", 28.00, 28.00, 20, "4.7", 3800,
                        "Cruise Bangkok's river and historic canals, visiting temples only reachable by boat."),
                new AttractionDTO("BKK-4", "Muay Thai Class & Fight Night", "sports", "⛷️",
                        "Bangkok, Thailand", "4h", 55.00, 55.00, 12, "4.7", 2100,
                        "Train with Muay Thai coaches then watch professional fighters at a local stadium.")
        ));

        // ── Amsterdam ────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Amsterdam, Netherlands", List.of(
                new AttractionDTO("AMS-1", "Anne Frank House Priority Tour", "culture", "🏛️",
                        "Amsterdam, Netherlands", "2h", 42.00, 42.00, 15, "4.9", 7100,
                        "Visit the secret annex where Anne Frank hid, with skip-the-line entry."),
                new AttractionDTO("AMS-2", "Canal Boat & Cheese Tour", "culinary", "🍷",
                        "Amsterdam, Netherlands", "3h", 45.00, 45.00, 20, "4.7", 3400,
                        "Cruise Amsterdam's UNESCO canals and taste artisan Dutch cheeses and stroopwafels."),
                new AttractionDTO("AMS-3", "Rijksmuseum Guided Tour", "culture", "🏛️",
                        "Amsterdam, Netherlands", "2h", 30.00, 30.00, 15, "4.8", 4800,
                        "Discover Rembrandt's Night Watch and Dutch Golden Age masterpieces with an expert."),
                new AttractionDTO("AMS-4", "Amsterdam Bike Tour", "nature", "🌿",
                        "Amsterdam, Netherlands", "3h", 28.00, 28.00, 15, "4.8", 5100,
                        "Cycle like a local through canal rings, Jordaan, and Vondelpark with a guide.")
        ));

        // ── Rome ─────────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Rome, Italy", List.of(
                new AttractionDTO("FCO-1", "Colosseum & Roman Forum Skip-the-Line", "culture", "🏛️",
                        "Rome, Italy", "3h", 52.00, 52.00, 20, "4.9", 9800,
                        "Enter the ancient Colosseum and walk through the Roman Forum with an expert guide."),
                new AttractionDTO("FCO-2", "Vatican Museums & Sistine Chapel Tour", "culture", "🏛️",
                        "Rome, Italy", "3h", 65.00, 65.00, 20, "4.9", 11200,
                        "Skip the line to Michelangelo's Sistine Chapel and St. Peter's Basilica."),
                new AttractionDTO("FCO-3", "Rome Food & Wine Tasting Tour", "culinary", "🍷",
                        "Rome, Italy", "3h", 75.00, 75.00, 10, "4.8", 3300,
                        "Taste gelato, cacio e pepe, supplì, and local wines in Trastevere and Testaccio."),
                new AttractionDTO("FCO-4", "Vespa Scooter Tour of Rome", "adventure", "🧗",
                        "Rome, Italy", "4h", 90.00, 90.00, 10, "4.7", 2700,
                        "Explore Rome's greatest sights on the back of a classic Italian Vespa.")
        ));

        // ── Madrid ───────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Madrid, Spain", List.of(
                new AttractionDTO("MAD-1", "Prado Museum Guided Tour", "culture", "🏛️",
                        "Madrid, Spain", "2h", 35.00, 35.00, 15, "4.8", 4500,
                        "Walk through one of the world's finest art museums with Goya, Velázquez, and Bosch."),
                new AttractionDTO("MAD-2", "Madrid Tapas & Flamenco Night", "culinary", "🍷",
                        "Madrid, Spain", "4h", 79.00, 79.00, 12, "4.9", 3900,
                        "Bar-hop through La Latina tasting authentic tapas then watch a live flamenco show."),
                new AttractionDTO("MAD-3", "El Retiro Park & Royal Palace Tour", "sightseeing", "📸",
                        "Madrid, Spain", "3h", 30.00, 30.00, 15, "4.7", 2800,
                        "Stroll through Madrid's beloved park and tour the opulent Royal Palace."),
                new AttractionDTO("MAD-4", "Real Madrid Stadium Tour", "sports", "⛷️",
                        "Madrid, Spain", "1.5h", 28.00, 28.00, 30, "4.6", 5300,
                        "Tour the Santiago Bernabéu Stadium and its trophy-filled museum.")
        ));

        // ── Toronto ──────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Toronto, Canada", List.of(
                new AttractionDTO("YYZ-1", "CN Tower EdgeWalk Experience", "adventure", "🧗",
                        "Toronto, Canada", "1.5h", 195.00, 195.00, 8, "4.9", 3100,
                        "Walk hands-free around the outside of the CN Tower, 356 metres above the city."),
                new AttractionDTO("YYZ-2", "Niagara Falls Day Trip", "nature", "🌿",
                        "Toronto, Canada", "10h", 85.00, 85.00, 20, "4.9", 8700,
                        "Visit one of the world's great natural wonders, just 90 minutes from Toronto."),
                new AttractionDTO("YYZ-3", "Kensington Market Food Tour", "culinary", "🍷",
                        "Toronto, Canada", "3h", 55.00, 55.00, 12, "4.7", 1800,
                        "Explore Toronto's most eclectic neighbourhood through its diverse street food scene.")
        ));

        // ── Honolulu ─────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Honolulu, USA", List.of(
                new AttractionDTO("HNL-1", "Pearl Harbor & USS Arizona Memorial", "culture", "🏛️",
                        "Honolulu, USA", "4h", 35.00, 35.00, 30, "4.9", 7200,
                        "Pay tribute at the USS Arizona Memorial and tour the WWII historic sites of Pearl Harbor."),
                new AttractionDTO("HNL-2", "Diamond Head Crater Hike", "adventure", "🧗",
                        "Honolulu, USA", "3h", 25.00, 25.00, 20, "4.8", 5400,
                        "Hike to the summit of Diamond Head for sweeping views of Waikiki and Honolulu."),
                new AttractionDTO("HNL-3", "Waikiki Surf Lesson", "sports", "⛷️",
                        "Honolulu, USA", "2h", 45.00, 45.00, 8, "4.7", 3900,
                        "Learn to surf on the gentle waves of Waikiki Beach with a certified local instructor."),
                new AttractionDTO("HNL-4", "Luau Dinner & Polynesian Cultural Show", "culinary", "🍷",
                        "Honolulu, USA", "4h", 125.00, 125.00, 100, "4.8", 6100,
                        "Feast on kalua pig and poi while watching authentic Polynesian hula and fire dancing.")
        ));

        // ── Seattle ──────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Seattle, USA", List.of(
                new AttractionDTO("SEA-1", "Pike Place Market Food Tour", "culinary", "🍷",
                        "Seattle, USA", "2.5h", 49.00, 49.00, 10, "4.8", 3200,
                        "Taste fresh salmon, local cheeses, and Pike Place Chowder at Seattle's iconic market."),
                new AttractionDTO("SEA-2", "Space Needle & Chihuly Garden", "sightseeing", "📸",
                        "Seattle, USA", "2h", 45.00, 45.00, 30, "4.7", 4800,
                        "Ride to the top of the Space Needle and explore the stunning Chihuly glass garden."),
                new AttractionDTO("SEA-3", "Mount Rainier Day Trip", "nature", "🌿",
                        "Seattle, USA", "10h", 95.00, 95.00, 15, "4.8", 3600,
                        "Visit the stunning Mount Rainier National Park, just 2 hours from Seattle.")
        ));

        // ── Boston ───────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Boston, USA", List.of(
                new AttractionDTO("BOS-1", "Freedom Trail Walking Tour", "culture", "🏛️",
                        "Boston, USA", "2.5h", 28.00, 28.00, 20, "4.8", 5900,
                        "Walk the 2.5-mile red-brick trail through 16 sites of America's revolutionary history."),
                new AttractionDTO("BOS-2", "Boston Harbour Islands Cruise", "nature", "🌿",
                        "Boston, USA", "3h", 45.00, 45.00, 50, "4.6", 2400,
                        "Cruise to the beautiful harbour islands for hiking, picnics, and coastal views."),
                new AttractionDTO("BOS-3", "New England Clam Chowder & Seafood Tour", "culinary", "🍷",
                        "Boston, USA", "2.5h", 55.00, 55.00, 10, "4.8", 2100,
                        "Taste lobster rolls, clam chowder, and oysters at Boston's best seafood spots.")
        ));

        // ── Vancouver ────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Vancouver, Canada", List.of(
                new AttractionDTO("YVR-1", "Capilano Suspension Bridge & Park", "nature", "🌿",
                        "Vancouver, Canada", "3h", 55.00, 55.00, 30, "4.7", 4700,
                        "Walk across a 140-metre suspension bridge above a rushing canyon in the rainforest."),
                new AttractionDTO("YVR-2", "Granville Island Market Food Tour", "culinary", "🍷",
                        "Vancouver, Canada", "2.5h", 49.00, 49.00, 10, "4.8", 2300,
                        "Graze through one of Canada's best public markets — fresh seafood, artisan cheeses, and more."),
                new AttractionDTO("YVR-3", "Stanley Park Bike & Seawall Tour", "nature", "🌿",
                        "Vancouver, Canada", "3h", 30.00, 30.00, 20, "4.8", 3800,
                        "Cycle the spectacular seawall around Stanley Park with mountain and ocean views.")
        ));

        // ── Frankfurt ────────────────────────────────────────────────────────
        ATTRACTION_INVENTORY.put("Frankfurt, Germany", List.of(
                new AttractionDTO("FRA-1", "Frankfurt Old Town (Römerberg) Tour", "culture", "🏛️",
                        "Frankfurt, Germany", "2h", 25.00, 25.00, 15, "4.7", 3100,
                        "Explore the beautifully restored medieval old town with its famous half-timbered houses."),
                new AttractionDTO("FRA-2", "Rhine Valley & Rüdesheim Day Trip", "nature", "🌿",
                        "Frankfurt, Germany", "9h", 75.00, 75.00, 20, "4.8", 2800,
                        "Cruise through the UNESCO Rhine Valley past hilltop castles and vineyard-draped slopes."),
                new AttractionDTO("FRA-3", "Frankfurt Beer & Bratwurst Evening", "culinary", "🍷",
                        "Frankfurt, Germany", "2.5h", 45.00, 45.00, 12, "4.7", 1900,
                        "Taste authentic Apfelwein and green sauce in the traditional Sachsenhausen taverns.")
        ));
    }

    // Normalises a raw destination input to a key in ATTRACTION_INVENTORY.
    // Accepts airport codes, city names, or "City, Country" strings.
    private static final Map<String, String> DEST_ALIASES = new HashMap<>();

    static {
        DEST_ALIASES.put("JFK", "New York, USA");
        DEST_ALIASES.put("LGA", "New York, USA");
        DEST_ALIASES.put("EWR", "New York, USA");
        DEST_ALIASES.put("NEW YORK", "New York, USA");
        DEST_ALIASES.put("LAX", "Los Angeles, USA");
        DEST_ALIASES.put("LOS ANGELES", "Los Angeles, USA");
        DEST_ALIASES.put("SFO", "San Francisco, USA");
        DEST_ALIASES.put("SAN FRANCISCO", "San Francisco, USA");
        DEST_ALIASES.put("CDG", "Paris, France");
        DEST_ALIASES.put("ORY", "Paris, France");
        DEST_ALIASES.put("PARIS", "Paris, France");
        DEST_ALIASES.put("LHR", "London, UK");
        DEST_ALIASES.put("LGW", "London, UK");
        DEST_ALIASES.put("LONDON", "London, UK");
        DEST_ALIASES.put("NRT", "Tokyo, Japan");
        DEST_ALIASES.put("HND", "Tokyo, Japan");
        DEST_ALIASES.put("TOKYO", "Tokyo, Japan");
        DEST_ALIASES.put("HNL", "Honolulu, USA");
        DEST_ALIASES.put("HONOLULU", "Honolulu, USA");
        DEST_ALIASES.put("ORD", "Chicago, USA");
        DEST_ALIASES.put("MDW", "Chicago, USA");
        DEST_ALIASES.put("CHICAGO", "Chicago, USA");
        DEST_ALIASES.put("MIA", "Miami, USA");
        DEST_ALIASES.put("MIAMI", "Miami, USA");
        DEST_ALIASES.put("SEA", "Seattle, USA");
        DEST_ALIASES.put("SEATTLE", "Seattle, USA");
        DEST_ALIASES.put("BOS", "Boston, USA");
        DEST_ALIASES.put("BOSTON", "Boston, USA");
        DEST_ALIASES.put("DXB", "Dubai, UAE");
        DEST_ALIASES.put("DUBAI", "Dubai, UAE");
        DEST_ALIASES.put("SIN", "Singapore");
        DEST_ALIASES.put("SINGAPORE", "Singapore");
        DEST_ALIASES.put("SYD", "Sydney, Australia");
        DEST_ALIASES.put("SYDNEY", "Sydney, Australia");
        DEST_ALIASES.put("ICN", "Seoul, South Korea");
        DEST_ALIASES.put("SEOUL", "Seoul, South Korea");
        DEST_ALIASES.put("BKK", "Bangkok, Thailand");
        DEST_ALIASES.put("BANGKOK", "Bangkok, Thailand");
        DEST_ALIASES.put("FRA", "Frankfurt, Germany");
        DEST_ALIASES.put("FRANKFURT", "Frankfurt, Germany");
        DEST_ALIASES.put("AMS", "Amsterdam, Netherlands");
        DEST_ALIASES.put("AMSTERDAM", "Amsterdam, Netherlands");
        DEST_ALIASES.put("YYZ", "Toronto, Canada");
        DEST_ALIASES.put("TORONTO", "Toronto, Canada");
        DEST_ALIASES.put("YVR", "Vancouver, Canada");
        DEST_ALIASES.put("VANCOUVER", "Vancouver, Canada");
        DEST_ALIASES.put("MAD", "Madrid, Spain");
        DEST_ALIASES.put("MADRID", "Madrid, Spain");
        DEST_ALIASES.put("FCO", "Rome, Italy");
        DEST_ALIASES.put("ROME", "Rome, Italy");
    }

    /**
     * Returns activities for the requested destination, scaled to the passenger count.
     *
     * @param destName    city name or airport code (e.g. "Paris", "CDG", "Paris, France")
     * @param countryName optional country hint (ignored if destName resolves unambiguously)
     * @param adults      number of adult passengers (min 1)
     * @param children    number of child passengers
     * @return list of AttractionDTO scaled to passenger count, or empty list if destination unknown
     */
    public List<AttractionDTO> searchAttractions(String destName, String countryName,
                                                 int adults, int children) {
        String key = resolveKey(destName, countryName);
        if (key == null || !ATTRACTION_INVENTORY.containsKey(key)) {
            return Collections.emptyList();
        }

        int passengers = Math.max(1, adults) + Math.max(0, children);
        List<AttractionDTO> baseList = ATTRACTION_INVENTORY.get(key);

        List<AttractionDTO> scaled = new ArrayList<>();
        for (AttractionDTO base : baseList) {
            double total = Math.round(base.getPricePerPerson() * passengers * 100.0) / 100.0;
            AttractionDTO dto = new AttractionDTO(
                    base.getId(), base.getName(), base.getCategory(), base.getIcon(),
                    base.getLocation(), base.getDuration(),
                    base.getPricePerPerson(), total,
                    base.getMaxGroupSize(), base.getRating(),
                    base.getReviews(), base.getDescription()
            );
            scaled.add(dto);
        }
        return scaled;
    }

    /** Resolves a raw dest_name + optional country_name to an inventory key. */
    private String resolveKey(String destName, String countryName) {
        if (destName == null || destName.isBlank()) return null;

        // 1. Try the raw string as an alias key (handles airport codes & full city names)
        String upper = destName.trim().toUpperCase();
        if (DEST_ALIASES.containsKey(upper)) return DEST_ALIASES.get(upper);

        // 2. Try stripping a parenthetical airport code: "Paris (CDG)" → "CDG"
        java.util.regex.Matcher m = java.util.regex.Pattern
                .compile("\\(([A-Z]{3})\\)").matcher(upper);
        if (m.find()) {
            String code = m.group(1);
            if (DEST_ALIASES.containsKey(code)) return DEST_ALIASES.get(code);
        }

        // 3. Try direct inventory key match (case-insensitive)
        for (String key : ATTRACTION_INVENTORY.keySet()) {
            if (key.equalsIgnoreCase(destName.trim())) return key;
        }

        // 4. Fuzzy: check if any inventory key starts with the given city name
        String lowerDest = destName.trim().toLowerCase();
        for (String key : ATTRACTION_INVENTORY.keySet()) {
            if (key.toLowerCase().startsWith(lowerDest)) return key;
        }

        return null;
    }
}